package Yandex.Sprint_1;

import java.util.Scanner;

public class A1_Reise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNumber;

        while (true) {
            System.out.println("Когда планируется путешествие? Введите номер месяца от 1 до 12.");
            monthNumber = scanner.nextInt();

            if (monthNumber > 0 && monthNumber < 13) {
                break;
            } else {
                System.out.println("Некорректный номер месяца. Введите ещё раз.");
            }
        }

        String season = "Зима";
        // Допишите условия ветвления в виде утверждений
        if (monthNumber < 6 && monthNumber > 2) {
            season = "Весна";
        } else if (monthNumber < 9 && monthNumber > 5) {
            season = "Лето";
        } else if (monthNumber < 12 && monthNumber > 8) {
            season = "Осень";
        }

        if (season.equals("Зима") || season.equals("Лето")) { // Не рекомендуем лететь в Париж в летние и зимние месяцы
            System.out.println("В этом сезоне лучше остаться в Москве.");
            return;
        }


        System.out.println("Укажите стоимость прямых билетов из Москвы в Париж:");
        int ticketMoscowParis = scanner.nextInt();
        System.out.println("Укажите стоимость билетов из Москвы в Париж с пересадкой в Лондоне:");
        int ticketMoscowLondonParis = scanner.nextInt();
        System.out.println("У вас есть британская виза?");
        System.out.println("1 - да, виза есть");
        System.out.println("0 - визы нет");
        int britainVisa = scanner.nextInt();

        boolean directTicketsCheaper = ticketMoscowParis > ticketMoscowLondonParis; // Сравнение стоимости билетов
        boolean hasBritainVisa = britainVisa == 1; // Проверка наличия визы

        if (directTicketsCheaper && hasBritainVisa) { // Проверить в одном условии наличие дешёвых билетов и визы
            System.out.println("Летим через Лондон!");
        } else {
            System.out.println("Летим через Париж!");
        }
    }
}