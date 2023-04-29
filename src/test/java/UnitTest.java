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
        Vector2d b = new Vector2d(1, 2);

        Line l = new Line(a, b);

        Vector2d a1 = new Vector2d(2, 0);
        Vector2d b1 = new Vector2d(2, 3);

        Line l1 = new Line(a1, b1);
        Point p = l.cross(l1);

        assert  p==null;
    }


    @Test
    public void test3() {

        Vector2d a = new Vector2d(0, 2);
        Vector2d b = new Vector2d(2, 4);

        Line l = new Line(a, b);

        Vector2d a1= new Vector2d(-4, 6);
        Vector2d b1 = new Vector2d(2, 0);

        Line l1 = new Line(a1, b1);
        Point p = l.cross(l1);
        assert  p.pos.equals(new Vector2d(0, 2));

    }
    @Test
    public void test4() {
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(3, 3);

        Line l = new Line(a, b);

        Vector2d a1= new Vector2d(2, -2);
        Vector2d b1 = new Vector2d(-2, 2);

        Line l1 = new Line(a1, b1);
        Point p = l.cross(l1);
        assert  p.pos.equals(new Vector2d(0, 0));
}

    @Test
    public void test5() {
        Vector2d a = new Vector2d(5, 0);
        Vector2d b = new Vector2d(0, 5);

        Line l = new Line(a, b);

        Vector2d a1= new Vector2d(2, -1);
        Vector2d b1 = new Vector2d(-2, 11);

        Line l1 = new Line(a1, b1);
        Point p = l.cross(l1);



        assert  p.pos.equals(new Vector2d(0, 5));
    }


}
