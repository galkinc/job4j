package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DummyBotTest - Test Class for a DummyBot Class.
 *
 * The bot can work with three orders:
 * 1. if <set>Hi, Bot</set> then <get>Hi smart!</get>
 * 2. if <set>Bye</set> then <get>See you soon!</get>
 * 3. if <set><AnyText/></set> then <get>This confuses me. Please, ask another question.</get>
 *
 * The tests were described by requirements in the task #31323
 */
public class DummyBotTest {

    @Test
    /**
     * Test for greetings
     */
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Hi, Bot"),
                is("Hi smart!")
        );
    }

    @Test
    /**
     * Test for farewell
     */
    public void whenByuBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Bye"),
                is("See you soon!")
        );
    }

    @Test
    /**
     * Test for <AnyText/>
     */
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("What is the sum of 2+2?"),
                is("This confuses me. Please, ask another question.")
        );
    }

}