package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Class FitTest - Tests for Fit Class (ideal weight calculation)
 * The tests in the test class was described by requirements in the task #41584
 *
 * @implNote
 * Ниже приведены формулы для вычисления идеального веса:
 *  Идеальный вес для мужчин = (рост в сантиметрах – 100) · 1,15.
 *  Идеальный вес для женщин = (рост в сантиметрах – 110) · 1,15.
 *
 * В этих тестах используется метод closeTo - Он нужен что сравнения чисел с плавающей точкой.
 * closeTo(value, round)
 * value - это ожидаемое значение
 * round - это диапазон округления значения. Например, если round = 0.1, то диапазон будет [value - 0.1, value + 0.1];
 * Ожидаемое значение должно попасть в этот диапазон.
 */
public class FitTest {

    @Test
    /*
     * manWeight - ideal weight calculation for man
     */
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    @Test
    /*
     * manWeight - ideal weight calculation for woman
     */
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
