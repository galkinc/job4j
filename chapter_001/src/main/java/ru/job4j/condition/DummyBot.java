package ru.job4j.condition;

/**
 * DummyBot - Class for a dummy bot.
 *
 * The bot can work with three orders:
 * 1. if <set>Hi, Bot</set> then <get>Hi smart!</get>
 * 2. if <set>Bye</set> then <get>See you soon!</get>
 * 3. if <set><AnyText/></set> then <get>This confuses me. Please, ask another question.</get>
 */
public class DummyBot {

    /**
     * Bot's answering
     * @param question Question/Order
     * @return Bot's answer.
     */
    public String answer(String question) {
        String rsl = "This confuses me. Please, ask another question.";
        if ("Hi, Bot".equals(question)) {
            rsl = "Hi smart!";
        } else if ("Bye".equals(question)) {
            rsl = "See you soon!";
        }
        return rsl;
    }

}
