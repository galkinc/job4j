package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 *  В этой задаче мы создадим класс Point, который описывает точку в системе координат.
 *  Также мы научим наш новый тип данных взаимодействовать с самим собой.
 *  Мы научим его считать расстояние до другой точки в системе координат.
 */

public class PointTest {

    @Test
    /**
     * Test for checking primitive variables (X and Y coordinates) and the constructor
     */
    public void whenSetCoordinatesOneOneThenGetTwo() {
        int x = 1;
        int y = 1;
        Point point = new Point(x, y);
        int[] result = point.getPoint();
        assertThat(result[0], is(x));
        assertThat(result[1], is(y));
    }

    @Test
    /**
     * Calculate distance between two points
     * @implNote Distance = Sqrt((x2 - x1)ˆ2 +(y2 - y1)ˆ2)
     */
    public void whenSetCoordinateThanGetSameCoordinate() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.47, 0.1));
    }

}
