package tracker.controller.action;

import tracker.controller.input.Input;
import tracker.model.Item;
import tracker.model.Tracker;
import tracker.view.StartUITemplate;

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
     * Exit status (could be used for exit from the program in the UI)
     */
    private boolean exit = false;

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
     * @deprecated Will be deleted
     * @return Array's length
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Setter for status of exit from the program
     * @param exit Exit status (Using for exit from the program in the UI)
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * Getter for exit status (Should we exit from the program?)
     * @return Exit status
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Key -> Action
     * @param command Key of the operation
     */
    public void select(String command) {
        for (UserAction action: this.actions) {
            if (action.key().equals(command)) {
                action.execute(this.input, this.tracker);
            }
        }
    }

    /**
     * Show the menu.
     */
    public void show() {
        System.out.print(StartUITemplate.menuHeader());
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.print(action.menu());
            }
        }
        System.out.print(StartUITemplate.menufooter());
    }

    /**
     * Get all menu as a List
     * @return List of the menu
     */
    public String[] getMenuList() {
        int size = this.actions.size();
        String[] menuList = new String[size];

        for (int i = 0; i < size; i++) {
            menuList[i] = this.actions.get(i).key();
        }

        return menuList;
    }

    /**
     * Create an Item
     */
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
            return StartUITemplate.menuLine(menuN, "Add a new task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("create the task"));
            String name = input.ask("Task name: ");
            String desc = input.ask("Task description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("The new task was created with ID: " + StartUITemplate.id(item.getId()));
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
            return StartUITemplate.menuLine(menuN, "Show all tasks.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("Show all tasks"));
            Item[] tasks = tracker.getAll();
            if (tasks.length > 0) {
                for (Item task: tasks) {
                    System.out.println(StartUITemplate.tableRowUI(task.getId(), task.getName(), task.getDesc()));
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
            return StartUITemplate.menuLine(menuN, "Edit a task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("Task editing"));
            String id = input.ask("Task id: ");
            String name = input.ask("Task new name: ");
            String desc = input.ask("Task new description: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Task " + StartUITemplate.id(id) + " was edited to:");
                System.out.println(StartUITemplate.tableRowUI(id, item.getName(), item.getDesc()));
            } else {
                System.out.println(StartUITemplate.errorUI("Wrong edit operation."));
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
            return StartUITemplate.menuLine(menuN, "Delete a task.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("Task deleting"));
            String id = input.ask("Task id: ");
            if (tracker.delete(id)) {
                System.out.println("Task " + StartUITemplate.id(id) + " was deleted.");
            } else {
                System.out.println(StartUITemplate.errorUI("Wrong delete operation."));
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
            return StartUITemplate.menuLine(menuN, "Find a task by Id.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("Find the task by ID"));
            String id = input.ask("Task id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(StartUITemplate.tableRowUI(item.getId(), item.getName(), item.getDesc()));
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
            return StartUITemplate.menuLine(menuN, "Find tasks by a name.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(StartUITemplate.headerUI("Find tasks by a name"));
            String name = input.ask("Task name: ");
            Item[] tasks = tracker.findByName(name);
            if (tasks.length > 0) {
                for (Item task: tasks) {
                    System.out.println(StartUITemplate.tableRowUI(task.getId(), task.getName(), task.getDesc()));
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
            return StartUITemplate.menuLine(menuN, "Program exit.");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.setExit(true);
        }

    }

}
