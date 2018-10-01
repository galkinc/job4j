package tracker;

import tracker.view.UITemplate;
import tracker.model.Tracker;
import tracker.controller.action.MenuTracker;
import tracker.controller.input.ConsoleInput;
import tracker.controller.input.Input;

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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Menu creation
     */
    public void init() {
        String awaiting = "Please input " + UITemplate.id("a number") + " from the menu: ";
        String wrongInput = UITemplate.errorUI("Wrong input value");
        boolean exit = false;

        while (!exit) {
            MenuTracker menu = new MenuTracker(this.input, this.tracker);
            menu.show();
            String answer = this.input.ask(awaiting);
            if (Integer.valueOf(answer) < menu.getActionsLength()) {
                menu.select(Integer.valueOf(answer));
                if (answer.equals("6")) {
                    exit = true;
                }
            } else {
                System.out.println(wrongInput);
            }
        }
    }

}
