package Yandex.Sprint2.bibliotek;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Contact contact = new Contact("Niko", "003");
    Contact contact1 = new Contact("Aleks", "001");
    Contact contact2 = new Contact("Luda", "002");
    Contact contact3 = new Contact("nata", "004");


    @BeforeEach
    void setUp() {


        ContactList contacts = new ContactList(2);
        contacts.addContact(contact.name, contact.phone);
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);


        System.out.println(contacts.findContactByName("Nirko") != null ? contacts
                .findContactByName("Nirko").toString() : "Contact is necessary");
        contacts.findAllContact();
        contacts.findAllContact();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {

    }
}