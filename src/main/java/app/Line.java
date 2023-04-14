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

    /**
     * Конструктор точки
     */
    @JsonCreator
    public Line(@JsonProperty("posA") Vector2d posA, @JsonProperty("posB") Vector2d posB) {
        this.posA = posA;
        this.posB = posB;
    }

    Point cross(Line l) {
        return new Point(new Vector2d(0, 0));
    }


}
