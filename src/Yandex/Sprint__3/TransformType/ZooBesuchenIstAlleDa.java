package Yandex.Sprint__3.TransformType;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooBesuchenIstAlleDa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Шиншилла");
        animals.add("Крокодил");
        animals.add("Лев");
        animals.add("Медведь");
        animals.add("Слон");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                Integer allTiere = animals.size();
                System.out.println("Сейчас в зоопарке можно увидеть " + allTiere + " животных:");

                for (String animal : animals) {
                    System.out.println(animal.toString());
                }
            } else if (command == 2) {
                System.out.println("Какое животное хотите добавить?");
                String animal = scanner.next();
                animals.add(animal); // добавьте животное
            } else if (command == 3) {
                System.out.println("Какое животное нужно удалить?");
                String animal = scanner.next();
                animals.remove(animal); // удалите животное, если список не пуст
            } else if (command == 4) {
                if (!animals.isEmpty()) {
                    animals.clear();
                    // очистите список
                    System.out.println("Все животные перевезены в другой зоопарк. Список пуст.");
                }
            } else if (command == 5) {
                System.out.println("Какое животное вы хотите увидеть в зоопарке?");
                String animal = scanner.next();
                boolean isAmPlatz = animals.contains(animal);
                if (isAmPlatz) {
                    System.out.println(animal + " на месте! Приходите посмотреть.");
                } else {
                    System.out.println("Такого животного сейчас нет в нашем зоопарке.");
                }
            } else {
                System.out.println("Успех!\n" +
                        "Nikolai, Java owns you. Follow the green button -->> ");
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Показать список животных в зоопарке.");
        System.out.println("2 - Добавить животное в список.");
        System.out.println("3 - Удалить животное из списка.");
        System.out.println("4 - Очистить список.");
        System.out.println("5 - Проверить, есть ли в зоопарке животное.");
        System.out.println("Любая другая цифра - Выйти из приложения.");
    }
}
