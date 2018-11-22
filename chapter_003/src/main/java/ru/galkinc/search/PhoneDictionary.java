package ru.galkinc.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Describing the phone dictionary
 */
public class PhoneDictionary {
    private List<Person> people = new ArrayList<Person>();

    public void add(Person person) {
        this.people.add(person);
    }

    /**
     * Return list of all people from the phone dictionary which have key value anywhere.
     * @param key Key for searching.
     * @return List of found records.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getPhone().contains(key)
                || person.getAddress().contains(key)) {
                    result.add(person);
            }
        }
        return result;
    }
}
