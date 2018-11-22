package ru.galkinc.search;

import org.junit.Test;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByAPartOfThePhoneThenGetSurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kirill", "Galkin", "732709", "Pushchino")
        );
        List<Person> persons = phones.find("2709");
        assertThat(persons.iterator().next().getSurname(), is("Galkin"));
    }

    @Test
    public void whenFindByANameThenGetSurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kirill", "Galkin", "732709", "Pushchino")
        );
        List<Person> persons = phones.find("Kirill");
        assertThat(persons.iterator().next().getSurname(), is("Galkin"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenFindByNotExistThenGetNoSuchElementException() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kirill", "Galkin", "732709", "Pushchino")
        );
        List<Person> persons = phones.find("00");
        assertThat(persons.iterator().next().getSurname(), is("Galkin"));
    }
}
