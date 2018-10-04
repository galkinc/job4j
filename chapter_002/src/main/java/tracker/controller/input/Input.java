package tracker.controller.input;

import tracker.controller.action.UserAction;

import java.util.List;

public interface  Input {

    String ask(String question);

    String ask(String question, List<UserAction> range);

}
