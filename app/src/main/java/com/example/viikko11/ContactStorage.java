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
            String g1 = c1.getContactGroup();
            String g2 = c2.getContactGroup();

            if (!g1.equals(g2)) {
                if (g1.equals("Työ")) {
                    return -1;
                }
                if (g2.equals("Työ")) {
                    return 1;
                }
            }

            return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
        });
    }
}