package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Load contacts from file
        try {
            addressBook.loadFromFile("AddressContact.ser");
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
                    addressBook.displayContacts();
                    break;
                case 2:
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
                    addressBook.addContact(new Contact(fullName, phone, address, email, birthDate));
                    break;
                case 3:
                    System.out.print("Enter the full name of the contact to search: ");
                    String searchName = scanner.nextLine();
                    Optional<Contact> contact = addressBook.searchContact(searchName);
                    contact.ifPresent(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter the full name of the contact to edit: ");
                    String editName = scanner.nextLine();
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
                    boolean edited = addressBook.editContact(editName, new Contact(newFullName, newPhone, newAddress, newEmail, newBirthDate));
                    if (edited) {
                        System.out.println("Contact edited successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the full name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    boolean deleted = addressBook.deleteContact(deleteName);
                    if (deleted) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 6:
                    running = false;
                    try {
                        addressBook.saveToFile("AddressContact.ser");
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
}
