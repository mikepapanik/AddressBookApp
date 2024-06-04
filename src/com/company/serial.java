package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class serial {

    private static final String FILE_NAME = "AddressContact.ser";
    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Load contacts from file
        try {
            loadFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + e.getMessage());
        }

        while (running) {
            System.out.println("\nAddress Book Application:");
            System.out.println("1. View all contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Edit a contact by name");
            System.out.println("5. Delete a contact by name");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayContacts();
                    break;
                case 2:
                    addContact(scanner);
                    break;
                case 3:
                    searchContact(scanner);
                    break;
                case 4:
                    editContact(scanner);
                    break;
                case 5:
                    deleteContact(scanner);
                    break;
                case 6:
                    running = false;
                    try {
                        saveToFile();
                    } catch (IOException e) {
                        System.err.println("Error saving to file: " + e.getMessage());
                    }
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter birth date: ");
        String birthDate = scanner.nextLine();
        contacts.add(new Contact(fullName, phone, address, email, birthDate));
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter the full name of the contact to search: ");
        String searchName = scanner.nextLine();
        Optional<Contact> contact = contacts.stream()
                .filter(c -> c.getFullName().equalsIgnoreCase(searchName))
                .findFirst();
        if (contact.isPresent()) {
            System.out.println(contact.get());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void editContact(Scanner scanner) {
        System.out.print("Enter the full name of the contact to edit: ");
        String editName = scanner.nextLine();
        Optional<Contact> contactOptional = contacts.stream()
                .filter(c -> c.getFullName().equalsIgnoreCase(editName))
                .findFirst();

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            System.out.print("Enter new full name: ");
            String newFullName = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();
            System.out.print("Enter new address: ");
            String newAddress = scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new birth date: ");
            String newBirthDate = scanner.nextLine();
            contact.setFullName(newFullName);
            contact.setPhone(newPhone);
            contact.setAddress(newAddress);
            contact.setEmail(newEmail);
            contact.setBirthDate(newBirthDate);
            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter the full name of the contact to delete: ");
        String deleteName = scanner.nextLine();
        Optional<Contact> contactOptional = contacts.stream()
                .filter(c -> c.getFullName().equalsIgnoreCase(deleteName))
                .findFirst();

        if (contactOptional.isPresent()) {
            contacts.remove(contactOptional.get());
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void saveToFile() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(contacts);
        }
    }

    private static void loadFromFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            contacts = (List<Contact>) objectIn.readObject();
        }
    }
}
