package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * Test Menu and User's UI
 *
 * Possible variations of input
 * 0. Add new Item
 * 1. Show all items
 * 2. Edit item
 * 3. Delete item
 * 4. Find item by Id
 * 5. Find items by name
 *
 */
public class StartUITest {
    // get the link to the standard System.out
    private PrintStream stdout = System.out;
    // Create a buffer for System out
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    //Names for the default object
    private static final String ITEM_NAME = "test name";
    //Description for the default object
    private static final String ITEM_DESC = "test desc";

    /**
     * Change standard System.out into the buffer
     * Executing before method
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Create Tracker and one item
     */
    private Tracker createObjects() {
        String name = ITEM_NAME;
        String desc = ITEM_DESC;
        Tracker tracker = new Tracker();
        tracker.add(new Item(name, desc));
        return tracker;
    }

    /**
     * Return back standard System.out
     * Executing after method
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    //UI templates block

    /**
     * Variables for the graphic menu.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String TEXT_COLOR = "\u001B[32m";
    private static final String MENU_ACTIVE_COLOR = "\u001B[35m";
    private static final String ATTENTION_COLOR = "\u001B[31m";

    /**
     * Menu template
     */
    private String menuUI() {
        return String.format(
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
    }

    /**
     * Use for drawing a row of the items list.
     * @param id Id
     * @param name Name
     * @param desc Desc
     * @return Row of the items list.
     */
    private String tableRowUI(String id, String name, String desc) {
        return String.format("%sID: %s %s; \t \t %sName: %s %s; \t \t \t %sDescription: %s %s;%n",
                TEXT_COLOR, ANSI_RESET, id, TEXT_COLOR, ANSI_RESET, name, TEXT_COLOR, ANSI_RESET, desc);
    }

    private String newTaskCreation(String id) {
        return String.format("The new task was created with ID: %s%s%s%n", TEXT_COLOR, id, ANSI_RESET);
    }

    private String editingTask(String id) {
        return String.format("Task %s%s%s was edited to:%n", TEXT_COLOR, id,  ANSI_RESET );
    }

    private String deleteTask(String id) {
        return String.format("Task %s%s%s was deleted.%n", TEXT_COLOR, id,  ANSI_RESET );
    }

    /**
     * Draw a header
     * @param name Text for header
     * @return Header
     */
    private String headerUI(String name) {
        return String.format("%n%n%s* %s * %s%n", TEXT_COLOR, name.toUpperCase(), ANSI_RESET);
    }

    /**
     * Error message drawing
     * @param message
     * @return Error message
     */
    private String errorUI(String message) {
        return String.format("%n%sError: %s %s", ATTENTION_COLOR, message, ANSI_RESET);
    }

    /**
     * UI input/output positive case testing: Create a new Item. (0. Add new Item)
     */
    @Test
    public void setUIWhenUserAddItemWithNameAndDescThenDrawMenuUpdateInfoMenu() {
        Tracker tracker = createObjects();
        String name = "addItem name";
        String desc = "addItem desc";
        Input input = new StubInput(new String[]{"0", name, desc, "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("create the task"))
                        .append(this.newTaskCreation(tracker.getAll()[1].getId()))
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Show all items
     */
    @Test
    public void setUIWhenUserChoosesShowAllThenDrawItem() {
        Tracker tracker = createObjects();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("show all tasks"))
                        .append(this.tableRowUI(tracker.getAll()[0].getId(), ITEM_NAME, ITEM_DESC))
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output negative case testing: Show all items
     */
    @Test
    public void setUIWhenUserChoosesShowAllButNotExistThenDrawMessage() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("show all tasks"))
                        .append("No results.")
                        .append(System.lineSeparator())
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Edit item. (2. Edit item)
     */
    @Test
    public void setUIWhenUserUpdateItemsNameAndDescThenDrawMenuEditInfoMenu () {
        Tracker tracker = createObjects();
        String newName = "New Name";
        String newDesc = "New Description";
        String id = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[]{"2", id, newName, newDesc, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                    .append(this.menuUI())
                    .append(this.headerUI("TASK EDITING"))
                    .append(this.editingTask(id))
                    .append(this.tableRowUI(id, newName, newDesc))
                    .append(this.menuUI())
                    .append(System.lineSeparator())
                    .toString()
                )
        );
    }

    /**
     * UI input/output negative case testing: Edit item. (2. Edit item)
     */
    @Test
    public void setUIWhenUserUpdateNotExistedItemsThenDrawError () {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"2", "123", "123", "123", "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("TASK EDITING"))
                        .append(this.errorUI("Wrong edit operation."))
                        .append(System.lineSeparator())
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Delete item. (3. Delete item)
     */
    @Test
    public void setUIWhenUserDeleteItemThenDrawMenuDeleteInfoMenu () {
        Tracker tracker = createObjects();
        String id = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("TASK deleting"))
                        .append(this.deleteTask(id))
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output negative case testing: Delete item. (3. Delete item)
     */
    @Test
    public void setUIWhenUserDeleteNotExistedItemsThenDrawError () {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"3", "132", "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("TASK deleting"))
                        .append(this.errorUI("Wrong delete operation."))
                        .append(System.lineSeparator())
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Find item by ID. (4. Find item by Id)
     */
    @Test
    public void setUIWhenUserFindsTaskByIDThenDrawMenuTasksListMenu () {
        Tracker tracker = createObjects();
        String id = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("Find the task by ID"))
                        .append(this.tableRowUI(id, ITEM_NAME, ITEM_DESC))
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output negative case testing: Find item by ID. (4. Find item by Id)
     */
    @Test
    public void setUIWhenUserFindsTaskByIDButNotExistThenDrawMessage () {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"4", "32", "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("Find the task by ID"))
                        .append("No results.")
                        .append(System.lineSeparator())
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Find item by a name. (5. Find item by a name)
     */
    @Test
    public void setUIWhenUserFindsTaskByNameThenDrawMenuTasksListMenu () {
        Tracker tracker = createObjects();
        String id = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[]{"5", ITEM_NAME, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("Find tasks by a name"))
                        .append(this.tableRowUI(id, ITEM_NAME, ITEM_DESC))
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output negative case testing: Find item by a name. (5. Find item by a name)
     */
    @Test
    public void setUIWhenUserFindsTaskByNameButNotExistThenDrawMessage () {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"5", ITEM_NAME, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(this.headerUI("Find tasks by a name"))
                        .append("No results.")
                        .append(System.lineSeparator())
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
     * UI input/output positive case testing: Find item by a name. (5. Find item by a name)
     */
    @Test
    public void setUIWhenUserExitProgramThenDrawMenu () {
        Tracker tracker = createObjects();
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(),
                is( new StringBuilder()
                        .append(this.menuUI())
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

}
