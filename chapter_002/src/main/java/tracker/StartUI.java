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
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    /**
     * Variables for the graphic menu.
     */
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String TEXT_COLOR = "\u001B[32m";
    private static final String MENU_ACTIVE_COLOR = "\u001B[35m";
    private static final String ATTENTION_COLOR = "\u001B[31m";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String TAB = "\t";

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
        String awaiting = "Please input"  + MENU_ACTIVE_COLOR + " a number " + ANSI_RESET + "from the menu: ";
        String wrongInput = ATTENTION_COLOR + "Wrong input value" + ANSI_RESET;

        boolean exit = false;
        while (!exit) {
            this.showMenu();
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
                case FINDID:
                    this.findById();
                    break;
                case FINDNAME:
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
    private void showMenu() {

        System.out.println(NEW_LINE + TEXT_COLOR + "******  MENU  ******" + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + ADD + ANSI_RESET
                    + TEXT_COLOR + " Add a new task." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + SHOW + ANSI_RESET
                    + TEXT_COLOR + " Show all task." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + EDIT + ANSI_RESET
                    + TEXT_COLOR + " Edit a task." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + DELETE + ANSI_RESET
                    + TEXT_COLOR + " Delete a task." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + FINDID + ANSI_RESET
                    + TEXT_COLOR + " Find a task by Id." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + FINDNAME + ANSI_RESET
                    + TEXT_COLOR + " Find a task by a name." + ANSI_RESET + NEW_LINE
                + MENU_ACTIVE_COLOR + EXIT + ANSI_RESET
                    + TEXT_COLOR + " Program exit." + ANSI_RESET + NEW_LINE
                + TEXT_COLOR + "********************" + ANSI_RESET + NEW_LINE);
    }

    /**
     * Create new item.
     */
    private void createItem() {
        System.out.println(NEW_LINE + TEXT_COLOR + "* NEW TASK *" + ANSI_RESET);
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
        System.out.println(NEW_LINE + TEXT_COLOR + "* ALL ITEMS *" + ANSI_RESET);
        Item[] tasks = this.tracker.getAll();
        if (tasks.length > 0) {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(tableRow(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
            }
        } else {
            System.out.println("No results.");
        }
    }

    /**
     * Use for drawing a row of the items list.
     * @param id Id
     * @param name Name
     * @param desc Desc
     * @return Row of the items list.
     */
    private String tableRow(String id, String name, String desc) {
        return  TEXT_COLOR + "ID: " + ANSI_RESET + id + ";" + TAB + TAB
                + TEXT_COLOR + "Name: " + ANSI_RESET + name + ";" + TAB + TAB + TAB
                + TEXT_COLOR + "Description: " + ANSI_RESET + desc;
    }

    /**
     * Item editing.
     */
    private void editItem() {
        System.out.println(NEW_LINE + TEXT_COLOR + "* EDIT TASK *" + ANSI_RESET);
        String id = this.input.ask("Task id: ");
        String name = this.input.ask("Task new name: ");
        String desc = this.input.ask("Task new description: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Task " + TEXT_COLOR + id + ANSI_RESET + " was edited to:" + NEW_LINE
                    + this.tableRow(id, item.getName(), item.getDesc()));
        } else {
            System.out.println(ATTENTION_COLOR + "Error: Wrong edit operation." + ANSI_RESET);

        }
    }

    /**
     * Item deleting.
     */
    private void deleteItem() {
        System.out.println(NEW_LINE + TEXT_COLOR + "* DELETE TASK *" + ANSI_RESET);
        String id = this.input.ask("Task id: ");
        if (this.tracker.delete(id)) {
            System.out.println("Task " + TEXT_COLOR + id + ANSI_RESET + " was deleted.");
        } else {
            System.out.println(ATTENTION_COLOR + "Error: Wrong delete operation." + ANSI_RESET);

        }
    }

    /**
     * Item finding by Id.
     */
    private void findById() {
        System.out.println(NEW_LINE + TEXT_COLOR + "* FIND TASK BY ID *" + ANSI_RESET);
        String id = this.input.ask("Task id: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(this.tableRow(item.getId(), item.getName(), item.getDesc()));
        } else {
            System.out.println("No results.");

        }
    }

    /**
     * Item finding by a name.
     */
    private void findByName() {
        System.out.println(NEW_LINE + TEXT_COLOR + "* FIND TASK BY NAME *" + ANSI_RESET);
        String name = this.input.ask("Task name: ");
        Item[] tasks = this.tracker.findByName(name);
        if (tasks.length > 0) {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(tableRow(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
            }
        } else {
            System.out.println("No results.");
        }
    }

}
