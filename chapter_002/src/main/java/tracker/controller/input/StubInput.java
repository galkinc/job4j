package tracker.controller.input;

import tracker.MenuOutException;

/**
 * Class for test user's input
 */
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

    /**
     * User's answers returning by sequential calling the Ask-method
     * @param question String for printing on the console.
     * @param range List of the possible values in menu (User Actions)
     * @return Whole sequence of inserted symbols.
     */
    @Override
    public String ask(String question, String[] range) {
        String key = this.answers[this.position++];
        boolean exist = false;

        for (String value : range) {
            if (value.equals(key)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of the range.");
        }
    }
}
