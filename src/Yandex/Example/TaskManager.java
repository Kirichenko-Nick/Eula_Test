package Yandex.Example;

public class TaskManager {
    private static final int MAX_TASKS = 10; // Максимальное количество задач
    private String[] tasks; // Массив для хранения задач
    private int taskCount; // Счётчик текущего количества задач

    public TaskManager() {
        tasks = new String[MAX_TASKS];
        taskCount = 0;
    }

    public void addTask(String task) {
        System.out.println("Начальное  количество задач " + taskCount);
        System.out.println("add Tsk " + task);
        if (taskCount < MAX_TASKS) {
         /*   for (int i = 0; i < tasks.length; i++) {
                System.out.println(i + " ---- " + tasks[i]);
            }
            System.out.println("add Tsk " + taskCount);*/
            tasks[taskCount] = task;

            /*for (int i = 0; i < tasks.length; i++) {
                System.out.println(i + " +++++ " + tasks[i]);
            }*/

            taskCount += 1;
            /*System.out.println("Текгщуу количество задач " + taskCount);*/
            System.out.println("Задача успешно добавлена.");
        } else {
            System.out.println("Список задач заполнен. Больше завести задач нельзя.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskCount) {
            for (int i = index; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[taskCount - 1] = null;
            taskCount--;
            System.out.println("Задача успешно удалена.");
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }

    public void listTasks() {
        if (taskCount == 0) {
            System.out.println("Задачи отсутствуют.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println("Index Task's :" + i + ". " + tasks[i]);
            }
        }
    }
}
