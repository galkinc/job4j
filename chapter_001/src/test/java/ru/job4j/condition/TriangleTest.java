package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Tests for Triangle class.
 */
public class TriangleTest {

    // Define three Point Objects for existed triangle.
    private Point a = new Point(0, 0);
    private Point b = new Point(0, 2);
    private Point c = new Point(2, 0);

    // Define three Point Objects for fake triangle.
    private Point af = new Point(0, 0);
    private Point bf = new Point(0, 2);
    private Point cf = new Point(0, 1);

    @Test
    /**
     * Test for the constructor of Triangle.
     */
    public void whenConstructorIsinitiateThenNothing() {
        // Create a triangle object by the Point objects
        Triangle triangle = new Triangle(this.a, this.b, this.c);
    }

    @Test
    /**
     * Test for method of a triangle existing
     *
     * Треугольник образуется соединением отрезками трех точек, не лежащих на одной прямой.
     *
     */
    public void whenFirstExistAndSecondIsnotThenTrue() {

        // Create a triangle object by the Point objects
        Triangle existedTriangle = new Triangle(this.a, this.b, this.c);
        // Create a fake triangle object by the Point objects
        Triangle fakeTriangle = new Triangle(this.af, this.bf, this.cf);

        //check triangles for existing (exist)
        assertThat(existedTriangle.doesExist(), is(true));
        //check triangles for existing (doesn't exist)
        assertThat(fakeTriangle.doesExist(), is(false));
    }

    @Test
    /**
     * Test for method of calculating the semi-perimeter along the lengths of the sides.
     * (ab + ac + bc) / 2
     */
    public void whenABAndACAndBCThenSumDevTwo() {
        // Create a triangle object by the Point objects
        Triangle triangle = new Triangle(this.a, this.b, this.c);
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        double result = triangle.semiPerimeter(ab, ac, bc);
        assertThat(result, closeTo(3.41, 0.1));
    }

    @Test
    /**
     * Test of calculation the area of the triangle by Heron's formula.
     * S = SQRT( P * (P - A) (P - B) (P - C))
     */
    public void whenSetRightValueForHeronThenS() {
        // Create a triangle object by the Point objects
        Triangle triangle = new Triangle(this.a, this.b, this.c);
        double result = triangle.areaCalc();
        assertThat(result, closeTo(2, 0.1));
    }

    @Test
    /**
     * If the triangle doesn't exist then -1.0
     */
    public void whenSetWrongValueForHeronThenMinusOne() {
        // Create a triangle object by the Point objects
        Triangle triangle = new Triangle(this.af, this.bf, this.cf);
        assertThat(triangle.areaCalc(), is(-1.0));
    }
}