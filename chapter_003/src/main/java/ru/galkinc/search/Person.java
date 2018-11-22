package ru.galkinc.search;

/**
 * Describing a person for the phone dictionary
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Constructor
     * @param name Name
     * @param surname Surname
     * @param phone Phone number
     * @param address address
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
