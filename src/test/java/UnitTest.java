import app.Line;
import app.Point;
import app.Task;
import misc.CoordinateSystem2d;
import misc.Vector2d;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс тестирования
 */
public class UnitTest {

    // тесты:
    // 1) проверка расстояния от точки до центра координат
    // 2) проверка высчета пересечения

    @Test
    public void test() {
        Vector2d a = new Vector2d(1, 0);
        assert a.length() == 1;


        Vector2d b = new Vector2d(3, 4);
    }


    @Test
    public void test2() {
        Vector2d a = new Vector2d(1, 0);
        Vector2d b = new Vector2d(0, 1);

        Line l = new Line(a, b);

        Vector2d a1 = new Vector2d(1, 2);
        Vector2d b1 = new Vector2d(1, 1);

        Line l1 = new Line(a1, b1);

        Point p = l.cross(l1);

        assert Math.abs(p.pos.x - 0.4) < 0.001 && Math.abs(p.pos.y - 0.8) < 0.001;
    }


}
