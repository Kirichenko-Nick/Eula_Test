package Yandex.Sprint_1;


import java.util.Scanner;

public class Practicum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свое имя:");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
    }
}