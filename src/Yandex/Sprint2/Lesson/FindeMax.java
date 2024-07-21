package Yandex.Sprint2.Lesson;

import java.util.Arrays;

public class FindeMax {
    public static void main(String[] args) {
        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses);
        System.out.println("Самая большая трата недели " + maxExpense);

        double[] expenses1 = {1012.50, 77.0, 810.6, 222150.50, 310.0, 486.0, 175.4};

        double maxExpense1 = Double.MIN_VALUE;
        for (int i = 0; i < expenses1.length; i++) {
            if (expenses[i] > maxExpense1) {
                maxExpense1 = expenses[i];
            }
        }

        System.out.println("Самая большая трата за неделю составила " + maxExpense1);
    }


    public static double findMaxExpense(double[] expensesAr) {
        double maxResult = Double.MIN_VALUE;
        for (double i : expensesAr) {
            maxResult = (maxResult > i) ? maxResult : i;
        }

        double maxExpenseLymbda = Arrays.stream(expensesAr).max().orElse(Double.MIN_VALUE);
        System.out.println("Самая большая трата недели " + maxExpenseLymbda);

        return maxResult;

    }

}