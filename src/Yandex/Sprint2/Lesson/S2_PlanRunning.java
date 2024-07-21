package Yandex.Sprint2.Lesson;

public class S2_PlanRunning {

    public static void main(String[] args) {
        int days = 3;
        int runs = 5;
        printRunsPlan(days, runs);
    }

    public static void printRunsPlan(int days, int runs) {
        for (int i = 1; i <= days; i++) {
            System.out.println("День " + i);
            for (int j = 1; j <= runs; j++) {
                System.out.println(" Пробежка " + j);
            }
        }
    }
}