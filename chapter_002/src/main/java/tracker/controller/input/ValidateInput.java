package tracker.controller.input;

import tracker.MenuOutException;
import tracker.view.StartUITemplate;

/**
 * It receives data from the system until entering of the correct characters.
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public String ask(String question, String[] range) {
        boolean isValid = false;
        String value = null;

        while (!isValid) {
            try {
                value = this.input.ask(question, range);
                isValid = true;
            } catch (MenuOutException moe) {
                System.out.println(StartUITemplate.errorUI("Please input key from the menu."));
            }
        }

        return value;
    }
}
