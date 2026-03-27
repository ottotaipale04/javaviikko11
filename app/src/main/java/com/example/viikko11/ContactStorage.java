package com.example.viikko11;

import java.util.ArrayList;

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
}