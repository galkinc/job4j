package ru.job4j.converter;

/**
 * Class Converter - currency converter
 */
public class Converter {

    // The conversion ratio (70 to 1) is fixed by the task requirement
    private int rubToEUR = 70;
    // The conversion ratio (60 to 1) is fixed by the task requirement
    private int rubToUSD = 60;

    /**
     * Converting RUB into EUR
     * @param value Amount of Russian rubles.
     * @return Amount of Euro.
     */
    public int rubleToEuro(int value) {
        return (value / this.rubToEUR);
    }

    /**
     * Converting RUB into USD
     * The conversion ratio (60 to 1) is fixed by the task requirement
     * @param value Amount of Russian rubles.
     * @return Amount of American dollars.
     */
    public int rubleToDollar(int value) {
        return (value / this.rubToUSD);
    }
}
