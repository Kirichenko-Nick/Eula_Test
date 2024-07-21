package Yandex.Sprint2.Lesson;

/*Решето Эратосфена"
Основная идея
        Алгоритм "Решето Эратосфена" предназначен для поиска всех простых
        чисел от 2 до n. Простое число — это число, которое делится только
        на 1 и на само себя. Все остальные числа являются составными, т.е.
        имеют дополнительные делители.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class EinfacheZahle {


    // ANSI escape codes for text color
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // ANSI escape codes for background color
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";


    public static void main(String[] args) {


        System.out.print("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int zahle = scanner.nextInt();
        System.out.println("Список простых чисел в массиве: " + CYAN + sieveOfEratosthenes(zahle).toString() + RESET);
        scanner.close();
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1]; // новая строка 1

        for (int i = 1; i <= n; i++) {
            isPrime[i] = true; // новая строка 2
        } // новая строка 3

        // 1 - не простое и не составное число, игнорируем
        isPrime[1] = false;

        for (int number = 2; number <= n; number++) {
            if (isPrime[number]) {
                list.add(number);
                System.out.println(PURPLE + number + " - простое число" + RESET);
                int numberMultiple = number * 2;

                while (numberMultiple <= n) {
                    isPrime[numberMultiple] = false;
                    numberMultiple += number; //новая строка 4
                }
            } else {
                System.out.println(GREEN + number + " - составное число" + RESET); //новая строка 5
            } // новая строка 6
        }
        return list;
    } // новая строка 7
}