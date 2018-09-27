package tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * Test Menu and User's input in UI
 *
 * Possible variations of input
 * 0. Add new Item
 * 2. Edit item
 * 3. Delete item
 *
 * @ToDO will be implemented during next tasks (not implemented yet)
 * Possible variations of showing
 * 1. Show all items
 * 4. Find item by Id
 * 5. Find items by name
 */
public class StartUITest {

    /**
     * UI input testing: Create a new Item. (0)
     */
    @Test
    public void setUIWhenUserAddItemWithNameAndDescThenTrackerHasNewItemWithSameNameAndSameDesc() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
        assertThat(tracker.getAll()[0].getDesc(), is("desc"));
    }

    /**
     * UI input testing: Edit item. (2)
     */
    @Test
    public void setUIWhenUserUpdateItemsNameAndDescThenTrackerHasUpdatedItemsNameAndDesc() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test editing", "edited the task", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test editing"));
        assertThat(tracker.findById(item.getId()).getDesc(), is("edited the task"));
    }

    /**
     * UI input testing: Delete item. (3)
     */
    @Test
    public void setUIWhenUserDeleteItemThenTrackerHasNotItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}
