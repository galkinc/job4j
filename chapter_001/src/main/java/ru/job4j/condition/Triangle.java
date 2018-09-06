package ru.job4j.condition;

/**
 * Class Triangle - Calculation of the area of a triangle.
 * Point class was used in the implementation.
 * @author galkinc
 */
public class Triangle {

    //Apexes of the triangle
    private Point a;
    private Point b;
    private Point c;

    //Sides of the triangle
    private double ab;
    private double bc;
    private double ac;

    /**
     * Class constructor for Triangle.
     *
     * @param a - x, y coordinates of a point a
     * @param b - x, y coordinates of a point b
     * @param c - x, y coordinates of a point c
     */
    public Triangle(Point a, Point b, Point c) {

        //Define points
        this.a = a;
        this.b = b;
        this.c = c;

        //Calculate distances between points.
        this.ab = this.a.distanceTo(this.b);
        this.bc = this.b.distanceTo(this.c);
        this.ac = this.a.distanceTo(this.c);
    }

    /**
     * Method of calculating the semi-perimeter along the lengths of the sides.
     * P = (ab + ac + bc) / 2
     */
    public double semiPerimeter(double ab, double ac, double bc) {
        return ((ab + ac + bc) / 2);
    }

    /**
     * Method checks the possibility of the triangle
     * a<c+b, c<a+b, b<c+a
     *
     * @return boolean true - the triangle exist; false - the triangle doesn't exist.
     */
    public boolean doesExist() {

        if ((this.ab + this.bc) > this.ac && (this.ab + this.ac) > this.bc && (this.ac + this.bc) > this.ab) {
           return true;
        }
        return false;
    }

    /**
     * Method return area of the triangle by the Heron's formula.
     * S = SQRT( P * (P - AB) * (P - BC) * (P - AC)),
     * where P = (ab + ac + bc) / 2
     *
     * @return Calculated area of the triangle. And return -1 if a triangle doesn't exist
     */
    public double areaCalc() {

        double result = -1.0;

        if (this.doesExist()) {
            //Calculate semi-perimeter along the lengths of the sides.
            double p = this.semiPerimeter(this.ab, this.ac, this.bc);

            //Return area of the triangle by the Heron's formula.
            result = Math.sqrt(
                    p * (p - this.ab) * (p - this.bc) * (p - this.ac)
            );
        }
        return result;

    }

}
