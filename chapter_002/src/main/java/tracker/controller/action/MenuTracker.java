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

        this.actions.add(new AddItem("0", "Add a new task."));
        this.actions.add(new ShowItems("1", "Show all tasks."));
        this.actions.add(new EditItem("2", "Edit a task."));
        this.actions.add(new DeleteItem("3", "Delete a task."));
        this.actions.add(new FindItemById("4", "Find a task by Id."));
        this.actions.add(new FindItemsByName("5", "Find tasks by a name."));
        this.actions.add(new ExitProgram("6", "Program exit."));
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
    private void setExit(boolean exit) {
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
            try {
                if (action.menuKey().equals(command)) {
                    action.execute(this.input, this.tracker);
                }
            } catch (NullPointerException e) {
                System.out.println("No results.");
            } catch (IllegalArgumentException e) {
                System.out.println(StartUITemplate.errorUI("Wrong arguments for the operation."));
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
            menuList[i] = this.actions.get(i).menuKey();
        }

        return menuList;
    }

    /**
     * Base class-template for Actions
     */
    private abstract class BaseAction implements UserAction {
        private String menuKey;
        private String menu;

        protected BaseAction(final String menuKey, final String menu) {
            this.menuKey = menuKey;
            this.menu = menu;
        }

        @Override
        public String menuKey() {
            return this.menuKey;
        }

        @Override
        public String menu() {
            return StartUITemplate.menuLine(this.menuKey, this.menu);
        }
    }

    /**
     * Create an Item
     */
    private class AddItem extends BaseAction {

        public AddItem(String menuKey, String menu) {
            super(menuKey, menu);
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

    /**
     * Show all existed Items
     */
    private class ShowItems extends BaseAction {

        public ShowItems(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) throws NullPointerException {
            System.out.println(StartUITemplate.headerUI("Show all tasks"));
            Item[] tasks = tracker.getAll();

            if (tasks.length <= 0) {
                throw new NullPointerException();
            }

            for (Item task : tasks) {
                System.out.println(StartUITemplate.tableRowUI(task.getId(), task.getName(), task.getDesc()));
            }
        }

    }

    /**
     * Edit an Item
     */
    private class EditItem extends BaseAction {

        public EditItem(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IllegalArgumentException {
            System.out.println(StartUITemplate.headerUI("Task editing"));
            String id = input.ask("Task id: ");
            String name = input.ask("Task new name: ");
            String desc = input.ask("Task new description: ");
            Item item = new Item(name, desc);

            if (!tracker.replace(id, item)) {
                throw new IllegalArgumentException();
            }

            System.out.println("Task " + StartUITemplate.id(id) + " was edited to:");
            System.out.println(StartUITemplate.tableRowUI(id, item.getName(), item.getDesc()));
        }
    }

    /**
     * Delete an Item
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IllegalArgumentException {
            System.out.println(StartUITemplate.headerUI("Task deleting"));
            String id = input.ask("Task id: ");

            if (!tracker.delete(id)) {
                throw new IllegalArgumentException();
            }

            System.out.println("Task " + StartUITemplate.id(id) + " was deleted.");
        }
    }

    /**
     * Find an Item by ID
     */
    private class FindItemById extends BaseAction {

        public FindItemById(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) throws NullPointerException {
            System.out.println(StartUITemplate.headerUI("Find the task by ID"));
            String id = input.ask("Task id: ");
            Item item = tracker.findById(id);

            if (item == null) {
                throw new NullPointerException();
            }

            System.out.println(StartUITemplate.tableRowUI(item.getId(), item.getName(), item.getDesc()));
        }
    }

    /**
     * Find an Item by a name
     */
    private class FindItemsByName extends BaseAction {

        public FindItemsByName(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) throws NullPointerException {
            System.out.println(StartUITemplate.headerUI("Find tasks by a name"));
            String name = input.ask("Task name: ");
            Item[] tasks = tracker.findByName(name);

            if (tasks.length <= 0) {
                throw new NullPointerException();
            }

            for (Item task : tasks) {
                System.out.println(StartUITemplate.tableRowUI(task.getId(), task.getName(), task.getDesc()));
            }
        }
    }

    /**
     * Exit from the program
     */
    private class ExitProgram extends BaseAction {

        public ExitProgram(String menuKey, String menu) {
            super(menuKey, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.setExit(true);
        }

    }

}
