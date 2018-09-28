package tracker;

import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    /**
     * Input link
     */
    private Input input;
    /**
     * Tracker link
     */
    private Tracker tracker;
    /**
     * UserAction[] link
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Constructor.
     *
     * Actions:
     * 0. Add new Item
     * 1. Show all items
     * 2. Edit item
     * 3. Delete item
     * 4. Find item by Id
     * 5. Find items by name
     * 6. Exit Program
     *
     * @param input   Input object
     * @param tracker Tracker object
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

        this.actions.add(new AddItem("0"));
        this.actions.add(new ShowItems("1"));
        this.actions.add(new EditItem("2"));
        this.actions.add(new DeleteItem("3"));
        this.actions.add(new FindItemById("4"));
        this.actions.add(new FindItemsByName("5"));
        this.actions.add(new ExitProgram("6"));
    }

    /**
     * Get a length of the actions array
     * @return Array's length
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Key -> Action
     * @param key Key of the operation
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.print(UITracker.menuHeader());
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.print(action.menu());
            }
        }
        System.out.print(UITracker.menufooter());
    }

    private class AddItem implements UserAction {
        private String menuN;

        public AddItem(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return this.menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Add a new task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("create the task"));
            String name = input.ask("Task name: ");
            String desc = input.ask("Task description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("The new task was created with ID: " + UITracker.id(item.getId()));
        }

    }

    private class ShowItems implements UserAction {
        private String menuN;

        public ShowItems(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Show all tasks.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("Show all tasks"));
            Item[] tasks = tracker.getAll();
            if (tasks.length > 0) {
                for (int i = 0; i < tasks.length; i++) {
                    System.out.println(UITracker.tableRowUI(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
                }
            } else {
                System.out.println("No results.");
            }
        }

    }

    private class EditItem implements UserAction {
        private String menuN;

        public EditItem(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Edit a task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("Task editing"));
            String id = input.ask("Task id: ");
            String name = input.ask("Task new name: ");
            String desc = input.ask("Task new description: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Task " + UITracker.id(id) + " was edited to:");
                System.out.println(UITracker.tableRowUI(id, item.getName(), item.getDesc()));
            } else {
                System.out.println(UITracker.errorUI("Wrong edit operation."));
            }
        }
    }

    private class DeleteItem implements UserAction {
        private String menuN;

        public DeleteItem(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Delete a task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("Task deleting"));
            String id = input.ask("Task id: ");
            if (tracker.delete(id)) {
                System.out.println("Task " + UITracker.id(id) + " was deleted.");
            } else {
                System.out.println(UITracker.errorUI("Wrong delete operation."));
            }
        }
    }

    private class FindItemById implements UserAction {
        private String menuN;

        public FindItemById(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Find a task by Id.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("Find the task by ID"));
            String id = input.ask("Task id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(UITracker.tableRowUI(item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("No results.");

            }
        }
    }

    private class FindItemsByName implements UserAction {
        private String menuN;

        public FindItemsByName(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Find tasks by a name.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(UITracker.headerUI("Find tasks by a name"));
            String name = input.ask("Task name: ");
            Item[] tasks = tracker.findByName(name);
            if (tasks.length > 0) {
                for (int i = 0; i < tasks.length; i++) {
                    System.out.println(UITracker.tableRowUI(tasks[i].getId(), tasks[i].getName(), tasks[i].getDesc()));
                }
            } else {
                System.out.println("No results.");
            }
        }
    }

    private class ExitProgram implements UserAction {
        private String menuN;

        public ExitProgram(String menuN) {
            this.menuN = menuN;
        }

        @Override
        public String key() {
            return menuN;
        }

        @Override
        public String menu() {
            return UITracker.menuLine(menuN, "Program exit.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

    }

}
