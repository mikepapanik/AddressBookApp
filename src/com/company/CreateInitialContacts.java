package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateInitialContacts {

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Mixalis Papanikolas", "6941234567", "Rodos,85104", "mpapanik@hotmail.com", "09/07/1994"));
        contacts.add(new Contact("Spyros Papamixalis", "6944444444", "Rodos", "papak@hotmail.com", "12/12/1978"));
        contacts.add(new Contact("Giannis Iwannou", "6989522224", "Cyprus", "giann@gmail.com", "04/02/1988"));
        contacts.add(new Contact("Maria Papanikola", "6989444234", "Rodos,85100", "maria@gmail.com", "07/04/1991"));
        contacts.add(new Contact("Nitsa Papadimitriou", "6978454234", "Symi", "nitsa@gmail.gr", "05/09/1971"));
        contacts.add(new Contact("Kwstas Pazaropoulos", "69894452041", "Athens", "pazkost@hotmail.com", "02/12/1973"));

        try (FileOutputStream fileOut = new FileOutputStream("AddressContact.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(contacts);
            System.out.println("Contacts have been serialized to AddressContact.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

