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
     * Variables for the graphic menu.
     */
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String TEXT_COLOR = "\u001B[32m";
    private static final String MENU_ACTIVE_COLOR = "\u001B[35m";
    private static final String ATTENTION_COLOR = "\u001B[31m";

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
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Menu logic.
     */
    public void init() {
        //Base text messages
        String awaiting = String.format("Please input %sa number%s from the menu: ", MENU_ACTIVE_COLOR, ANSI_RESET);
        String wrongInput = this.errorUI("Wrong input value");

        boolean exit = false;
        while (!exit) {
            this.showMenuUI();
            String answer = this.input.ask(awaiting);
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_ID:
                    this.findById();
                    break;
                case FIND_NAME:
                    this.findByName();
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

    /**
     * Console-menu drawing.
     */
    private void showMenuUI() {
        String menu = String.format(
                "%n %s******  MENU  ******%s %n"
                + "%s%s%s %sAdd a new task.%s %n"
                + "%s%s%s %sShow all tasks.%s %n"
                + "%s%s%s %sEdit a task.%s %n"
                + "%s%s%s %sDelete a task.%s %n"
                + "%s%s%s %sFind a task by Id.%s %n"
                + "%s%s%s %sFind tasks by a name.%s %n"
                + "%s%s%s %sProgram exit.%s %n"
                + "%s********************%s %n",
                TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, ADD, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, SHOW, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, EDIT, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, DELETE, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, FIND_ID, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, FIND_NAME, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                MENU_ACTIVE_COLOR, EXIT, ANSI_RESET, TEXT_COLOR, ANSI_RESET,
                TEXT_COLOR, ANSI_RESET);

        System.out.println(menu);
    }

    /**
     * Use for drawing a row of the items list.
     * @param id Id
     * @param name Name
     * @param desc Desc
     * @return Row of the items list.
     */
    private String tableRowUI(String id, String name, String desc) {
        return String.format("%sID: %s %s; \t \t %sName: %s %s; \t \t \t %sDescription: %s %s;",
                TEXT_COLOR, ANSI_RESET, id, TEXT_COLOR, ANSI_RESET, name, TEXT_COLOR, ANSI_RESET, desc);
    }

    /**
     * Draw a header
     * @param name Text for header
     * @return Header
     */
    private String headerUI(String name) {
        return String.format("%n%s* %s * %s", TEXT_COLOR, name.toUpperCase(), ANSI_RESET);
    }

    private String errorUI(String message) {
        return String.format("%n%sError: %s %s", ATTENTION_COLOR, message, ANSI_RESET);
    }

    /**
     * Create new item.
     */
    private void createItem() {
        System.out.println(this.headerUI("create the task"));
        String name = this.input.ask("Task name: ");
        String desc = this.input.ask("Task description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("The new task was created with ID: " + TEXT_COLOR + item.getId() + ANSI_RESET);
    }

    /**
     * Showing all items in the tracker.
     */
    private void showItems() {
        System.out.println(this.headerUI("Show all tasks"));
        Item[] tasks = this.tracker.getAll();
        if (tasks.length > 0) {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(tableRowUI(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
            }
        } else {
            System.out.println("No results.");
        }
    }

    /**
     * Item editing.
     */
    private void editItem() {
        System.out.println(this.headerUI("Task editing"));
        String id = this.input.ask("Task id: ");
        String name = this.input.ask("Task new name: ");
        String desc = this.input.ask("Task new description: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Task " + TEXT_COLOR + id + ANSI_RESET + " was edited to:");
            System.out.println(this.tableRowUI(id, item.getName(), item.getDesc()));
        } else {
            System.out.println(this.errorUI("Wrong edit operation."));
        }
    }

    /**
     * Item deleting.
     */
    private void deleteItem() {
        System.out.println(this.headerUI("Task deleting"));
        String id = this.input.ask("Task id: ");
        if (this.tracker.delete(id)) {
            System.out.println("Task " + TEXT_COLOR + id + ANSI_RESET + " was deleted.");
        } else {
            System.out.println(this.errorUI("Wrong delete operation."));
        }
    }

    /**
     * Item finding by Id.
     */
    private void findById() {
        System.out.println(this.headerUI("Find the task by ID"));
        String id = this.input.ask("Task id: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(this.tableRowUI(item.getId(), item.getName(), item.getDesc()));
        } else {
            System.out.println("No results.");

        }
    }

    /**
     * Item finding by a name.
     */
    private void findByName() {
        System.out.println(this.headerUI("Find tasks by a name"));
        String name = this.input.ask("Task name: ");
        Item[] tasks = this.tracker.findByName(name);
        if (tasks.length > 0) {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(tableRowUI(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
            }
        } else {
            System.out.println("No results.");
        }
    }

}
