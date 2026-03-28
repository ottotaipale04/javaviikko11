package com.example.viikko11;

import java.util.ArrayList;
import java.util.Collections;

public class ContactStorage {
    ArrayList<Contact> contacts = new ArrayList<>();

    private static ContactStorage instance = null;
    static public ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int c) {
        contacts.remove(c);
    }

    public void sortAlphabetically() {
        Collections.sort(contacts, (c1, c2) -> {
            return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
        });
    }

    public void sortByGroup() {
        Collections.sort(contacts, (c1, c2) -> {
            int comparison = c1.getContactGroup().compareToIgnoreCase(c2.getContactGroup());

            if (comparison == 0) {
                return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
            }
            return comparison;
        });
    }
}