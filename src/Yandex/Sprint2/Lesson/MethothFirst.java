package Yandex.Sprint2.Lesson;


import java.util.Scanner;

public class MethothFirst {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeUserByName();
        sayHelloByTime();
        printSuccess();

    }

    public static void welcomeUserByName() {
        System.out.println("Как вас зовут?");
        String name = scanner.nextLine();

        System.out.println("Рад познакомиться, " + name + "!");
    }

    public static void sayHelloByTime() {
        int currentHour = -1;
        while (true) {
            System.out.println("Который час?");

            try {
                currentHour = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Числа в диапазоне от 0 до 24 \nПопробуй еще раз!!!");
                continue;  // Skip the rest of the loop and prompt again
            }

            if (currentHour < 0 || currentHour > 24) {
                System.out.println("Числа в диапазоне от 0 до 24 \nПопробуй еще раз!!!");
            } else {
                break;
            }
        }


        if (currentHour < 6 || currentHour >= 22) {
            System.out.println("Доброй ночи!");
        } else if (currentHour < 12 && currentHour >= 6) {
            System.out.println("Доброе утро!");
        } else if (currentHour < 18 && currentHour >= 12) {
            System.out.println("Добрый день!");
        } else if (currentHour < 22 && currentHour >= 18) {
            System.out.println("Добрый вечер!");
        }
    }

    public static void printSuccess() {
        System.out.println("У вас уже неплохо получается программировать!");
    }

}