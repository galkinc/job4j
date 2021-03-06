package tracker;

import tracker.view.StartUITemplate;
import tracker.model.Tracker;
import tracker.controller.action.MenuTracker;
import tracker.controller.input.Input;
import tracker.controller.input.ValidateInput;
import tracker.controller.input.ConsoleInput;

public class StartUI {

    /**
     * Variable for input.
     */
    private final Input input;

    /**
     * Repository of items.
     */
    private final Tracker tracker;

    /**
     * Constructor.
     * @param input Data input.
     * @param tracker Repository of items.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Launcher.
     * @param args Arguments
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * Menu creation
     */
    public void init() {
        String awaiting = "Please input " + StartUITemplate.id("a number") + " from the menu: ";
        MenuTracker menu = new MenuTracker(this.input, this.tracker);

        while (!menu.isExit()) {
            menu.show();
            String answer = this.input.ask(awaiting, menu.getMenuList());
            menu.select(answer);
        }
    }

}
