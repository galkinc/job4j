package tracker.controller.action;

import tracker.controller.input.Input;
import tracker.model.Tracker;

public interface UserAction {

    String key();

    String menu();

    void execute(Input input, Tracker tracker);

}
