package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Optional<Contact> searchContact(String fullName) {
        return contacts.stream()
                .filter(contact -> contact.getFullName().equalsIgnoreCase(fullName))
                .findFirst();
    }

    public boolean editContact(String fullName, Contact updatedContact) {
        Optional<Contact> contactOptional = searchContact(fullName);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setFullName(updatedContact.getFullName());
            contact.setPhone(updatedContact.getPhone());
            contact.setAddress(updatedContact.getAddress());
            contact.setEmail(updatedContact.getEmail());
            contact.setBirthDate(updatedContact.getBirthDate());
            return true;
        }
        return false;
    }

    public boolean deleteContact(String fullName) {
        Optional<Contact> contactOptional = searchContact(fullName);
        if (contactOptional.isPresent()) {
            contacts.remove(contactOptional.get());
            return true;
        }
        return false;
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(contacts);
        }
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            contacts = (List<Contact>) objectIn.readObject();
        }
    }
}
