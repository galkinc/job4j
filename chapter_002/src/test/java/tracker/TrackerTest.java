package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest{

    //Adding tests
    @Test
    public void whenAddItemThenGetItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    //finding by Id tests
    @Test
    public void whenAddItemThenFindByID() {
        String id;
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item result = new Item();

        tracker.add(item);
        id = item.getId();
        result = tracker.findById(id);
        assertThat(result, is(item));
    }

    @Test
    public void whenNoItemWithIDThenNull() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        assertThat(tracker.findById("80"), is(nullValue()));
    }

    // Replacing by Id
    @Test
    public void setTwoItemsWhenReplaceItemParamsThenGetNewItemParams() {
        String newName = "New name";
        String newDesc = "New desc";
        Tracker tracker = new Tracker();
        Item object = tracker.add(new Item("Old name","Old desc"));
        String id = object.getId();
        tracker.replace(object.getId(), new Item(newName,newDesc));
        assertThat(tracker.findById(id).getName(), is(newName));
        assertThat(tracker.findById(id).getDesc(), is(newDesc));
    }

    @Test
    public void whenSuccessReplaceItemThenGetTrue() {
        Tracker tracker = new Tracker();
        Item object = tracker.add(new Item("Old name","Old desc"));
        Boolean status = tracker.replace(object.getId(), new Item("New name","New desc"));
        assertThat(status, is(true));
    }

    @Test
    public void whenFailReplaceItemThenGetFalse() {
        String id = "-1";
        Tracker tracker = new Tracker();
        Item object = tracker.add(new Item("Old name","Old desc"));
        Boolean status = tracker.replace(id, new Item("New name","New desc"));
        assertThat(status, is(false));
    }

    //deleting by Id
    @Test
    public void whenCreateItemWithNameThenDeleteItemGetNull() {
        Tracker tracker = new Tracker();
        Item object = new Item("For deleting","");
        tracker.add(object);
        String existedName = "Some name";
        Item existedItem = new Item(existedName,"");
        tracker.add(existedItem);
        String id = object.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
        assertThat(tracker.findById(existedItem.getId()).getName(), is(existedName));
    }

    @Test
    public void whenDeletingItemIsSuccessThenGetTrue() {
        Tracker tracker = new Tracker();
        Item object = tracker.add(new Item("Name","Desc"));
        Boolean status = tracker.delete(object.getId());
        assertThat(status, is(true));
    }

    @Test
    public void whenDeletingItemIsFailThenGetFalse() {
        String id = "-1";
        Tracker tracker = new Tracker();
        Item object = tracker.add(new Item("Name","Desc"));
        Boolean status = tracker.delete(id);
        assertThat(status, is(false));
    }

    //getting all
    @Test
    public void whenGetAllFromTrackerThenGetArrayWithAllItems() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[99];
        for (int i = 0; i < items.length; i++){
            items[i] = tracker.add(new Item(i + " item", i + " description"));
        }
        assertThat(tracker.getAll(), is(items));
    }

    //finding by name
    @Test
    public void setTrackerWithItemsWhenFindItemByNameThenGetItem() {
        String name = "Name for finding";
        Tracker tracker = new Tracker();
        Item object1 = new Item(name, "1");
        Item object2 = new Item(name, "3");
        tracker.add(object1);
        tracker.add(new Item("balbalba", "2"));
        tracker.add(object2);
        tracker.add(new Item("just a name","4"));

        Item[] expect = {
                object1,
                object2
        };

        assertThat(tracker.findByName(name), is(expect));
    }

    @Test
    public void setTrackerWithItemsWhenFindNotExistItemByNameThenGetEmptyArray() {
        String name = "Name for finding";
        Tracker tracker = new Tracker();
        tracker.add(new Item("Name 1", "1"));
        tracker.add(new Item("Name 2", "2"));
        tracker.add(new Item("Name 3", "3"));
        tracker.add(new Item("Name 4", "4"));

        assertThat(tracker.findByName("Name for finding"), is(new Item[0]));
    }

    //@Before
    //@After
    //@Parameterized.Parameters
}
