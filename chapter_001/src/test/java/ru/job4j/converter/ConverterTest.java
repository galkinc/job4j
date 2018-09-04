package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/*
 * ConverterTest - Tests for the currency converter class
 * The test class is described in the task requirement.
 */
public class ConverterTest {

    /*
     * Test for the function of conversion of RUB into USD
     * The conversion ratio (60 to 1) is fixed by the task requirement
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /*
     * Test for the function of conversion of RUB into EUR
     * The conversion ratio (70 to 1) is fixed by the task requirement
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
}
