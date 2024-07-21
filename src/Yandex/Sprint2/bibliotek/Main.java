package Yandex.Sprint2.bibliotek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = 3;
        ContactList contacts = new ContactList(limit);

        while (true) {
            printMenu();
            int nextInt = scanner.nextInt();

            if (nextInt == 1) {
                if (contacts.contacts.size() == contacts.limit) {
                    System.out.println("It's full !");

                } else {
                    System.out.print("Please enter the name: ");
                    String name = scanner.next();
                    System.out.print("Please enter the telephone number: ");
                    String telefonnummer = scanner.next();
                    contacts.addContact(name, telefonnummer);
                }

            } else if (nextInt == 2) {
                if (contacts.contacts.isEmpty()) {
                    System.out.println("Dictanory is empty.");

                } else {
                    System.out.println("Please enter the name");
                    String name = scanner.next();
                    Contact contact = contacts.findContactByName(name);
                    if (contact != null) {
                        System.out.println(contact.toString());
                    } else {
                        System.out.println("We have no such contacts.");
                    }
                }

            } else if (nextInt == 3) {
                contacts.findAllContact();

            } else if (nextInt == 4) {
                System.out.println("Goodbye");
                scanner.close();
                return;
            } else {
                System.out.println("No, these command");
            }
        }
    }


    public static void printMenu() {
        System.out.println(" -     -     -     -     -   ".repeat(5));
        System.out.println("Chouse numerical operation!!!");
        System.out.println("1. Add contact");
        System.out.println("2. Search by name.");
        System.out.println("3. Print all.");
        System.out.println("4. Exit");
        System.out.println(" -     -     -     -     -   ".repeat(5));
    }
}