package tracker;

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
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }
}
