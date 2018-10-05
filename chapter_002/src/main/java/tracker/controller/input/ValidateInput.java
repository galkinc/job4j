package tracker.controller.input;

import tracker.MenuOutException;
import tracker.controller.action.UserAction;
import tracker.view.UITemplate;

import java.util.List;

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

    public String ask(String question, List<UserAction> range) {
        boolean isValid = false;
        String value = null;

        while (!isValid) {
            try {
                value = this.input.ask(question, range);
                isValid = true;
            } catch (MenuOutException moe) {
                System.out.println(UITemplate.errorUI("Please input key from the menu."));
            } catch (NumberFormatException nfe) {
               System.out.println(UITemplate.errorUI("Wrong format for menu input value."));
            }
        }

        return value;
    }
}
