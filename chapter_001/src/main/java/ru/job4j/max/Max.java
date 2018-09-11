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

    /**
     * Identifying a maximum value
     * @param a - first value
     * @param b - second value
     * @return Maximum value
     */
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Method maxFromThree: Maximum of three numbers
     * Task #190
     *
     * @param c
     * @return Maximum value
     */
    public int maxFromThree(int a, int b, int c) {
        int maximum = new Max().max(new Max().max(a, b), c);
        return maximum;
    }

}