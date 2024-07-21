package Yandex.Sprint2.Lesson;

import java.util.Scanner;

public class S2_SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую зарплату вы получите в этом месяце?");
        int salary = scanner.nextInt();
        System.out.println("Сколько планируете потратить на транспорт?");
        int transportMoney = scanner.nextInt();
        System.out.println("Сколько запланировано на супермаркеты?");
        int foodMoney = scanner.nextInt();
        System.out.println("Какую сумму хотите отложить?");
        int savings = scanner.nextInt();

        // вызовите метод correctExpenses с правильными аргументами

        // Напечатайте запланированные траты
        correctExpenses(salary, transportMoney, foodMoney, savings);
        System.out.println("Вы планировали потратить: транспорт — " + transportMoney + ", "
                + "еда — " + foodMoney + ", "
                + "сбережения — " + savings + ".");

    }

    public static void correctExpenses(int salary, int transportMoney, int foodMoney, int savings) {

        int expensesSum = transportMoney + foodMoney + savings; // считаем расходы
        if (expensesSum > salary) { // проверяем, не превышают ли расходы зарплату
            int lackMoney = expensesSum - salary; // считаем, сколько не хватает
            // считаем излишек средств

            // пока не начнёт хватать денег на транспорт — сокращаем траты на 100 рублей
            while ((salary - foodMoney) < transportMoney) {
                foodMoney = foodMoney - 100;
            }
            // если не хватает денег на жизнь — не откладываем
            if (transportMoney + foodMoney + savings > salary) {
                savings = 0;
            }

            // печатаем рекомендации
            System.out.println("Придётся пересмотреть планы, вам не хватает " + lackMoney);
            System.out.println("Рекомендуемые траты: "
                    + "еда — " + foodMoney + ", "
                    + "сбережения — " + savings + ".");

        } else {
            int leftMoney = salary - expensesSum;
            System.out.println("В этом месяце дебет с кредитом сошлись!");
            System.out.println("Свободных средств " + leftMoney);
        }

    }
}

/*
Успех!
        Да пребудет с вами Spring! Двигайтесь дальше ->*/
