package ru.job4j.condition;

/*
 *  В этой задаче мы создадим класс Point, который описывает точку в системе координат.
 *  Также мы научим наш новый тип данных взаимодействовать с самим собой.
 *  Мы научим его считать расстояние до другой точки в системе координат.
 */

/*
 * Class Point- describe a point in the coordinate system.
 */
public class Point {

    // X coordinate of the point.
    private int x;
    // Y coordinate of the point.
    private int y;

    /**
     * Class constructor
     *
     * @param x - x coordinate of a point
     * @param y - y coordinate of a point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Test methods for primitive coordinate testing
    public int[] getPoint() {
        int[] coordinates = {this.x, this.y};
        return coordinates;
    }

    /**
     * Calculate distance between two point
     * Distance = Sqrt((x2 - x1)ˆ2 +(y2 - y1)ˆ2)
     *
     * @param that
     * @return
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("The distance between A and B is equal " + result);
    }

}
