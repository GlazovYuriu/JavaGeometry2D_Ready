package app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.Rect;
import misc.CoordinateSystem2d;
import misc.CoordinateSystem2i;
import misc.Vector2d;
import misc.Vector2i;

/**
 * Класс линии
 */
public class Line {

    /**
     * Координаты точки
     */
    public final Vector2d posA;
    public final Vector2d posB;


    public final double a;
    public final double b;
    public final double c;


    /**
     * Конструктор точки
     */
    @JsonCreator
    public Line(@JsonProperty("posA") Vector2d posA, @JsonProperty("posB") Vector2d posB) {
        this.posA = posA; //x1,y1
        this.posB = posB; //x2,y2
        if (this.posA.x == this.posB.x || this.posA.y == this.posB.y) {
            if (this.posA.x == this.posB.x) {
                a = 1;
                b = 0;
                c = -this.posA.x;
            } else {
                a = 0;
                b = 1;
                c = -this.posA.y;
            }
        } else {
            a = this.posB.y - this.posA.y;
            b = -this.posB.x + this.posA.x;
            c = -this.posA.x * (this.posB.y - this.posA.y) + this.posA.y * (this.posB.x - this.posA.x);

        }

    }

    public Point cross(Line l) {
        double xp;
        double yp;
        if (this.a * l.b != this.b * l.a) {
            xp = -(this.b * l.c - l.b * this.c) / (this.a * l.b - l.a * this.b);
            yp = (l.a * this.c - this.a * l.c) / (this.a * l.b - l.a * this.b);
            return new Point(new Vector2d(xp, yp));
        } else {
            return null;
        }
    }


    public void paint(Canvas canvas, CoordinateSystem2i windowCS, CoordinateSystem2d ownCS) {
        try (Paint p = new Paint()) {
            // опорные точки линии
            Vector2i pointA = windowCS.getCoords(posA, ownCS);
            Vector2i pointB = windowCS.getCoords(posB, ownCS);
            // вектор, ведущий из точки A в точку B
            Vector2i delta = Vector2i.subtract(pointA, pointB);
            // получаем максимальную длину отрезка на экране, как длину диагонали экрана
            int maxDistance = (int) windowCS.getSize().length();



            // рисуем ответ (две линии)
            Vector2i renderPointA = Vector2i.sum(pointA, Vector2i.mult(delta, maxDistance));
            Vector2i renderPointB = Vector2i.sum(pointA, Vector2i.mult(delta, -maxDistance));
            // рисуем линию
            canvas.drawLine(renderPointA.x, renderPointA.y, renderPointB.x, renderPointB.y, p);

            canvas.drawRect(Rect.makeXYWH(pointA.x - 2, pointA.y - 2, 4, 4), p);
            canvas.drawRect(Rect.makeXYWH(pointB.x - 2, pointB.y - 2, 4, 4), p);
        }

        /*
            // рисуем ответ (две линии)

            // рисуем линию
            canvas.drawLine(renderPointA.x, renderPointA.y, renderPointB.x, renderPointB.y, paint);


            // задаём красный цвет
            paint.setColor(Misc.getColor(200, 255, 0, 0));
            // рисуем исходные точки
            canvas.drawRRect(RRect.makeXYWH(pointA.x - 4, pointA.y - 4, 8, 8, 4), paint);
            canvas.drawRRect(RRect.makeXYWH(pointB.x - 4, pointB.y - 4, 8, 8, 4), paint);
         */
    }
}
