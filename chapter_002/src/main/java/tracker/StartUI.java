package tracker;

public class StartUI {
    /** --- Menu ---
     * 0. Add new Item
     * 1. Show all items
     * 2. Edit item
     * 3. Delete item
     * 4. Find item by Id
     * 5. Find items by name
     * 6. Exit Program
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

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
     * Menu logic.
     */
    public void init() {
        //Base text messages
        String awaiting = "Please input " + UITracker.id("a number") + " from the menu: ";
        String wrongInput = UITracker.errorUI("Wrong input value");
        boolean exit = false;

        while (!exit) {
            MenuTracker menu = new MenuTracker(this.input, this.tracker);
            menu.show();

            String answer = this.input.ask(awaiting);
            switch (answer) {
                case ADD:
                    menu.select(0);
                    break;
                case SHOW:
                    menu.select(1);
                    break;
                case EDIT:
                    menu.select(2);
                    break;
                case DELETE:
                    menu.select(3);
                    break;
                case FIND_ID:
                    menu.select(4);
                    break;
                case FIND_NAME:
                    menu.select(5);
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println(wrongInput);
                    break;
            }
        }
    }

}
