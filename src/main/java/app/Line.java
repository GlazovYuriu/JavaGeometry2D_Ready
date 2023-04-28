package app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import misc.Vector2d;

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
        if(this.posA.x==this.posB.x || this.posA.y==this.posB.y) {
          if(this.posA.x==this.posB.x ){
              a=1;
              b=0;
              c=-this.posA.x;
          }
          else{
              a=0;
              b=1;
              c=-this.posA.y;
          }
        }
        else{a=this.posB.y - this.posA.y;
             b=-this.posB.x + this.posA.x;
             c=-this.posA.x*(this.posB.y - this.posA.y)+this.posA.y*(this.posB.x - this.posA.x);

        }

    }

    public Point cross(Line l) {
        double xp;
        double yp;
        if(this.a * l.b != this.b *l.a ) {
            yp = ((l.a * this.c / this.a) - l.c) / (l.b - this.b / this.a);
            xp = ((l.b * this.c / this.b) - l.c) / (l.a - (this.a * l.b / this.b));
            return new Point(new Vector2d(xp, yp));
        }
        else{
            return null;
        }
    }


}
