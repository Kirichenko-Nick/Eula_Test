package Yandex.Sprint_1;

import java.util.Scanner;

public class A1_366Ok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой год вы хотите проверить?");
        int year = scanner.nextInt();

        boolean isLeapYear = ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)); // Составьте логическое выражение
        if (!isLeapYear) { // Напишите ветвление, где isLeapYear станет условием
            // Используйте фразы для печати:
            System.out.println("Согласно григорианскому календарю, этот год - не високосный!");
        } else {

            System.out.println("Согласно григорианскому календарю, этот год - високосный!");
        }
    }
}

