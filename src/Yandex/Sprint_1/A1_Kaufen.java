package Yandex.Sprint_1;

import java.util.Random;
import java.util.Scanner;

class A1_Kaufen {
    public static void main(String[] args) {
        // объявили массив трат за неделю (7 дней)
        double[] expenses = new double[7];
        Random random = new Random();
        double expense = random.nextInt(100); // в первый день потрачено 50 рублей

        // заполнили массив, используя цикл for
        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = expense;
            expense = expense + 100;
        }
        System.out.println("Расходы за неделю успешно занесены в приложение!");

        Scanner scanner = new Scanner(System.in);
        while (true) { // добавили бесконечный цикл — теперь не страшно ошибаться много раз
            System.out.println("Расходы за какой день вы хотите проверить. Выберите значение от 0 (пн) до 6 (вс).");

            int index = scanner.nextInt();
            // считайте ввод пользователя из консоли и сохраните в переменной index

            if (index < 0) {
                System.out.println("Выбрано неверное значение! Минимальное значение - 0");
                continue;
            } else if (index >= expenses.length) {
                System.out.println("Выбрано неверное значение! Максимальное значение - 6");
                continue;

            } else {
                // если пользователь ввёл корректный индекс,
                // то программа должна вывести значение нужного элемента и завершить работу (прервать цикл)
                System.out.println("Потрачено " + expenses[index] + " рублей");
                break;
            }
        }
        scanner.close();
    }
}