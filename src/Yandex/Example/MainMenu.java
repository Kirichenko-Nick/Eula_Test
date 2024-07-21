package Yandex.Example;

import java.util.Scanner;

public class MainMenu {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Вывести список задач");
            System.out.println("4. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // перенос строки

            if (choice == 1) {
                System.out.print("Введите задачу: ");
                String task = scanner.nextLine();
                taskManager.addTask(task);
            } else if (choice == 2) {
                System.out.print("Введите номер задачи для удаления: ");
                int index = scanner.nextInt();
                taskManager.removeTask(index);
            } else if (choice == 3) {
                taskManager.listTasks();
            } else if (choice == 4) {
                System.out.println("Всего доброго!");
                return;
            } else {
                System.out.println("Указанная команда не найдена.");
            }
        }
    }
}

