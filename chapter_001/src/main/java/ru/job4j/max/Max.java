package ru.job4j.max;

/**
 * Defining the maximum of two numbers by ternary (three-way) operator.
 *
 * expression1 ? expression2 : expression3
 *
 * Here, expression1 can be any expression that evaluates to a boolean value. If expression1 is
 * true, then expression2 is evaluated; otherwise, expression3 is evaluated. The result of the ?
 * operation is that of the expression evaluated. Both expression2 and expression3 are required
 * to return the same type, which can’t be void.
 *
 * Here is an example of the way that the ? is employed:
 * ratio = denom == 0 ? 0 : num / denom;
 *
 * When Java evaluates this assignment expression, it first looks at the expression to the left of
 * the question mark. If denom equals zero, then the expression between the question mark and
 * the colon is evaluated and used as the value of the entire ? expression. If denom does not
 * equal zero, then the expression after the colon is evaluated and used for the value of the
 * entire ? expression. The result produced by the ? operator is then assigned to ratio.
 *
 */
public class Max {

    //variables for comparison
    private int a;
    private int b;

    /**
     * Class constructor
     *
     * @param a - first value
     * @param b - second value
     */
    public Max(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Identifying a maximum value
     * @return Maximum value
     */
    public int max() {
        return this.a > this.b ? this.a : this.b;
    }
}