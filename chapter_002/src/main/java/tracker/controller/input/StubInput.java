package tracker.controller.input;

import tracker.controller.action.UserAction;

import java.util.List;

public class StubInput implements Input {
    /**
     * Variable for the user's answering
     */
    private final String[] answers;

    /**
     * Counter for execution of the ask method
     */
    private int position;

    /**
     * Constructor
     * @param answers User's answering
     */
    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    /**
     * User's answers returning by sequential calling the Ask-method
     * @param question String for printing on the console.
     * @return Whole sequence of inserted symbols.
     */
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    public String ask(String question, List<UserAction> range) {
        return question;
    }

}
