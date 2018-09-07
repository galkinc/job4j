package ru.job4j.loop;

/**
 * Factorial calculation
 */
public class Factorial {

    /**
     * Factorial calculation
     * The factorial for 5 is 120 (1 * 2 * 3 * 4 * 5).
     * @param n
     * @return Factorial of n
     */
    public int factorialCalc(int n) {

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
                factorial *= i;
        }
        return factorial;
    }
}
