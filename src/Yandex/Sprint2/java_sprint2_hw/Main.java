package Yandex.Sprint2.java_sprint2_hw;

import java.util.Optional;
import java.util.Scanner;

/**
 * вывод меню и выбор пункта
 */


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            String cmdMenu = null;

            cmdMenu = scanner.nextLine();


            int cmdMenuToInt = 0;
            try {
                cmdMenuToInt = Integer.parseInt(cmdMenu);
            } catch (NumberFormatException e) {

                System.out.println("Введите пожалуйста число соответствующее команде. А Вы ввели " +
                        Optional.ofNullable(cmdMenu).orElse("ничего"));
                continue;
            }

            switch (cmdMenuToInt) {
                case 1:
                    tracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    tracker.changeStepGoal();
                    break;
                case 3:
                    tracker.printStatistic();

                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выбирите одно из действий по выбору:\n");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}
