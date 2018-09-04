package ru.job4j.calculator;

/**
 * Class Fit - ideal weight calculations
 * The tests in the test class was described by requirements in the task #41584
 */
public class Fit {
    /**
     * Ideal weight calculation for man.
     * @param height height (in cm).
     * @return ideal weight for man (in kg).
     * @implNote Ideal weight for man  = (height in cm – 100) · 1,15.
     */
    public double manWeight(double height) {
        double idealWeight = (height - 100) * 1.15;
        return (idealWeight);
    }

    /**
     * Ideal weight calculation for woman.
     * @param height height (in cm).
     * @return  ideal weight for woman (in kg).
     * @implNote Ideal weight for woman  = (height in cm – 110) · 1,15.
     */
    public double womanWeight(double height) {
        double idealWeight = (height - 110) * 1.15;
        return (idealWeight);
    }
}
