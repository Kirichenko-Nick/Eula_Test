package Yandex.Sprint_1;

import java.util.Random;
import java.util.Scanner;

public class A_1_While {

    public static void main(String[] args) {
  /*      Random random = new Random(); // генерирует случайное число

        int dayCount = 0; // для учёта дней накоплений
        int moneyTotal = 0; // суммарное количество накоплений
        int moneyToday; // сколько откладываем сегодня
        int goal = 5000; // финансовая цель

        while (moneyTotal <= goal) {
            moneyToday = random.nextInt(300); // случайная сумма на сегодня
            moneyTotal = moneyTotal + moneyToday; // добавили эти деньги в копилку
            dayCount = dayCount + 1; // засчитали день
        }

        System.out.println("Ура! Вы смогли накопить " + goal + " за " + dayCount + " дней.");

        */

// ---------------------------------------

       /* Scanner scanner = new Scanner(System.in); // позволяет считать ответ пользователя
        int x = 0; // хранит ответ пользователя

        while (x != 5) { // цикл выполняется, пока х не равна 5
            System.out.println("Сколько будет 2+3?");
            x = scanner.nextInt(); // считываем из консоли число и присваиваем переменной х
        }
        System.out.println("Пример решён правильно!\n");
        System.out.println("Das Ende");*/


        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько денег у вас сейчас: ");
        double balance = scanner.nextDouble(); // ваши сбережения
        int years = 0;
        System.out.println("Сколько денег получить от вклада: ");
        double goal = scanner.nextDouble();
        System.out.println("Под какой процент % годовых? ");
        double rente = scanner.nextDouble();

        while (balance <= goal) {
            balance = balance + balance * rente / 100;
            years++;
        }

        System.out.printf("Через %d лет у вас будет %.2f!\n", years, balance);

    }
}


