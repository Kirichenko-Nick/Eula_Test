package Yandex.Sprint2.bibliotek;

import java.util.ArrayList;

public class ContactList {
    public ArrayList<Contact> contacts = new ArrayList<>();
    public int limit;

    public ContactList(int limit) {
        this.limit = limit;
    }

    public void addContact(String name, String phone) {
        if (contacts.size() == limit) {
            System.out.println("The directory is full!");
            return;
        }
        Contact contact = new Contact(name, phone);
        contacts.add(contact);
    }


    public void addContact(Contact contact) {
        if (contacts.size() == limit) {
            System.out.println("Es ist foll!!!");
            return;
        }
        contacts.add(contact);
    }

    public Contact findContactByName(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getName().equals(name)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void findAllContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contact!");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);
            System.out.printf("Contact: %d, -  %s%n", i + 1, contact.toString());

        }
    }
}

/*
ystem.out.printf("Имя: %s Возраст: %d Оценка: %.2f%n", name, age, score);
        Спецификаторы формата
        %d — для целых чисел (decimal)
        %f — для чисел с плавающей запятой (float)
        %s — для строк (string)
        %c — для символов (character)
        %n — для новой строки (platform-independent newline character)
        Более сложный пример
        java
        Копировать код
public class PrintfExample {
    public static void main(String[] args) {
        String product = "Widget";
        int quantity = 10;
        double price = 12.99;

        System.out.printf("Product: %-10s Quantity: %5d Price: %8.2f%n", product, quantity, price);
    }
}

Здесь:

        %-10s — строка, выровненная по левому краю с шириной поля 10 символов.
        %5d — целое число с шириной поля 5 символов.
        %8.2f — число с плавающей запятой с шириной поля 8 символов и двумя знаками после запятой.
        Объяснение
        Ширина поля: Целое число после % указывает минимальную ширину поля. Если значение меньше этой ширины, оно будет дополнено пробелами.
        Точность: Для чисел с плавающей запятой точность указывается после точки (например, .2 в %8.2f), что означает два знака после запятой.
        Выравнивание: Символ - перед шириной поля указывает на выравнивание по левому краю.
        Используя метод System.out.printf, можно гибко форматировать вывод данных, делая его более читаемым и организованным.

*/







