package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    //Constructor tests
    @Test
    public void whenCreateItemWithNameAndDescriptionThenGetNameAndDescription() {
        String name = "Name for the test";
        String description = "Description for the test";

        Item item = new Item(name, description);
        String itemName = item.getName();
        String itemDesc = item.getDesc();

        assertThat(itemName, is(name));
        assertThat(itemDesc, is(description));
    }

    //Getter and setter tests
    @Test
    public void whenSetIDfForItemThenGetTheID() {
        String id = "1";

        Item item = new Item();
        item.setId(id);

        assertThat(id, is(item.getId()));
    }

    @Test
    public void whenSetNameAndDescThenGetNameAndDesc() {
        String newName = "The new name";
        String newDesc = "The new description";

        Item item = new Item();
        item.setName(newName);
        item.setDesc(newDesc);

        assertThat(item.getName(), is(newName));
        assertThat(item.getDesc(), is(newDesc));
    }

    @Test
    public void whenSetACreatedDateTimeThenGetTheCreatedDateTime() {
        Item item = new Item();
        item.setCreated(1234L);
        assertThat(item.getCreated(), is(1234L));
    }
}
