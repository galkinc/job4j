package tracker;

public class StartUITest implements Input {

    private String[] answers;
    private int position = 0;

    public StartUITest(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question)  {
        return answers[position++];
    }

}
