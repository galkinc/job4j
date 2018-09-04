package ru.job4j.calculate;

/**
 * Class Calculator - example of simple calculation
 *
 */
public class Calculator {
    // double result - value for calculation result saving
    private double result;

    /**
     * Method add - summarising and saving the result into this.result.
     *
     * @param first – the first summand.
     * @param second – the second summand.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method add - subtraction and saving the result into this.result.
     *
     * @param minuend – the minuend.
     * @param subtrahend – the subtrahend.
     */
    public void subtract(double minuend, double subtrahend) {
        this.result = minuend - subtrahend;
    }

    /**
     * Method div - division of summands and input result into this.result.
     *
     * @param dividend – the dividend.
     * @param divisor – the divisor.
     */
    public void div(double dividend, double divisor) {
        this.result = dividend / divisor;
    }

    /**
     * Method add - multiplication and save result into this.result.
     *
     * @param multiplicand – the multiplicand.
     * @param multiplier – the multiplier (factor).
     */
    public void multiple(double multiplicand, double multiplier) {
        this.result = multiplicand * multiplier;
    }

    /**
     * Method getResult - should be called after the corresponding mathematical operation.
     *
     * @return get result of last calculation.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Method setResult - using for autotest
     * @param result
     */
    public void setResult(double result) {
        this.result = result;
    }

}
