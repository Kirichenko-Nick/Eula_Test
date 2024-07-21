package Yandex.Sprint_1;

import java.util.Random;
import java.util.Scanner;

public class A_1_Speile_Random {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // не создавайте объект класса Random
        int randomInt = new Random().nextInt(1, 100); // генерирует новое число от 0 до 1000

        int userInput = -1; // это нужно, чтобы цикл запустился, если Random выдаст 0
        int step = 0;
        System.out.println("Я загадал число от 0 до 100.");
        System.out.println("Ваш ход:");

        // запускаем цикл игры
        while (userInput != randomInt) {
            step++;
            userInput = scanner.nextInt(); // в этой переменной должен сохраняться ввод пользователя
            if (userInput > randomInt) { // условие проверяется в цикле
                System.out.println("Меньше");
            }
            // Второе условие
            if (userInput < randomInt) { // условие проверяется в цикле
                System.out.println("Больше");
            }
        }
        // печатаем, когда число угадано
        System.out.printf("Вы великолепны! Именно %d я загадал. \nИ вы гениальнo  нашли его всего за %d ходов !!! \n ☺ ☺ ☺", randomInt, step);
    }
}



