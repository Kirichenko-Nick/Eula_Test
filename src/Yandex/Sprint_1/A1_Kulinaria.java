package Yandex.Sprint_1;


import java.util.Scanner;

class A1_Kulinaria {
    public static void main(String[] args) {
        String[] dishes = {"Манная каша", "Кофе Капучино", "Пицца Маргарита", "Панна-котта", "Суши"}; // Массив
        System.out.println("Вы продегустировали пять блюд.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс блюда, которое хотите переместить:");
        System.out.println("0-Манная каша");
        System.out.println("1-Кофе Капучино");
        System.out.println("2-Пицца Маргарита");
        System.out.println("3-Панна-котта");
        System.out.println("4-Суши");

        // Считайте из консоли индекс блюда, которое нужно переместить
        int firstIndex = scanner.nextInt();


        System.out.println("Введите позицию, на которую хотите его переместить, от 0 до 4:");
        // Объявите переменную secondIndex для нового положения (индекса) блюда, считайте его из консоли
        int secondIndex = scanner.nextInt();

        // Сохраните значение блюда под индексом firstIndex в переменную swap
        String swap = dishes[firstIndex];

        // Присвойте блюду с индексом firstIndex значение блюда под индексом secondIndex
        dishes[firstIndex] = dishes[secondIndex];

        // Присвойте блюду с индексом secondIndex значение переменной swap
        dishes[secondIndex] = swap;

        System.out.println("Ваш рейтинг блюд:");
        System.out.println(dishes[0]);
        System.out.println(dishes[1]);
        System.out.println(dishes[2]);
        System.out.println(dishes[3]);
        System.out.println(dishes[4]);

    }
}