package tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Generating a unique id by SystemTime + random integer
     * @return Unique id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Add item to the tracker
     * Method adds unique ID for Item item object.
     * @param item Item object
     * @return Item object
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;

        return item;
    }

    /**
     * Track Item fast replacing.
     * Replacing the item in the this.items array by id of the element.
     *
     * Method doesn't use validation (Item setters and getters)
     * For more safety method please use replace(String id, Item subject)
     *
     * @param id ID of Item which will be replaced
     * @param subject New Item for replacement
     * @return True/false - status of the operation
     */
    public boolean fastReplace(String id, Item subject) {
        boolean status = false;
        String subjectId;

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                items[i] = subject;
                items[i].setId(id);
                status = true;
                break;
            }
        }

        return status;
    }

    /**
     * Track Item replacing.
     * Method use validation which should be implemented in Item Class (Item setters and getters)
     *
     * @param id ID of Item which will be replaced
     * @param subject New Item for replacement
     * @return True/false - status of the operation
     */
    public boolean replace(String id, Item subject) {
        boolean status = false;
        String subjectId;

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                items[i].setName(subject.getName());
                items[i].setDesc(subject.getDesc());
                items[i].setCreated(subject.getCreated());
                items[i].setComments(subject.getComments());
                items[i].setId(id);
                status = true;
                break;
            }
        }

        return status;
    }


    /**
     * Deleting of an Item.
     * @implNote implemented by moving the array.
     * @param id Item ID for replacing
     * @return True/false - status of the operation
     */
    public boolean delete(String id) {
        boolean status = false;

        for (int i = 0; this.items[i] != null && i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - 1);
                this.position--;
                status = true;
                break;
            }
        }
        return status;
    }

    /**
     * Return array which include all Items
     * @return array which include all Items
     */
    public Item[] getAll() {
        //reduce null elements
        Item[] result = new Item[this.position];
        for (int i = 0; this.items[i] != null && i < position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Getting Items array by Name
     * Checking Items in the tracker and return all items with the searched name.
     *
     * @param key Searched name
     * @return Array with found items
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.items.length];
        int resultIndex = 0;

        for (int i = 0; this.items[i] != null && i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                tmp[resultIndex++] = this.items[i];
            }
        }

        return Arrays.copyOf(tmp, resultIndex);

    }

    /**
     * Getting an item by id
     * @param id Item ID
     * @return Item with id, If there isn't an item with id the method returns null.
     */
    public Item findById(String id) {
        Item result = null;

        //for (Item item : this.items) - can cause NullPointerException
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
}
