package tracker.controller.input;

import tracker.MenuOutException;
import tracker.controller.action.UserAction;
import tracker.view.UITemplate;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    public String ask(String question, List<UserAction> range) {
        boolean isValid = false;
        String value = null;

        while (!isValid) {
            try {
                value = super.ask(question, range);
                isValid = true;
            } catch (MenuOutException moe) {
                System.out.println(UITemplate.errorUI("Please input key from the menu"));
            } catch (NumberFormatException nfe) {
                System.out.println(UITemplate.errorUI("Wrong input value"));
            }
        }

        return value;
    }
}
