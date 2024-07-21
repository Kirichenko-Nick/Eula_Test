package Yandex.Sprint__3.FinansKalkulatorMitHach;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        if (expensesByCategories.isEmpty()) {
            System.out.println("Трат пока нет.");
        } else {


            for (String category : expensesByCategories.keySet()) {
                System.out.println(category);
                ArrayList<Double> expenses = expensesByCategories.get(category);
                for (Double expense : expenses) {
                    System.out.println(expense);
                }
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        ArrayList<Double> expenses = expensesByCategories.get(category);
        for (Double expense : expenses) {
            if (expense > maxExpense) {
                maxExpense = expense;
            }
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    // напишите метод для получения суммы всех трат
    Double getExpensesSum() {
        Double expensesSum = 0.0;
        for (ArrayList<Double> aus : expensesByCategories.values()) {
            for (int i = 0; i < aus.size(); i++) {
                expensesSum += aus.get(i);
            }
        }
        return expensesSum;
    }

    // напишите метод для удаления категории
    void removeCategory(String category) {

        expensesByCategories.remove(category);


    }

    String getMaxCategoryName() {
        String maxCategoryName = "";
        double maxCategorySum = 0.0;

        for (String key : expensesByCategories.keySet()) {
            double zwieschen = 0.0;
            for (Double sumI : expensesByCategories.get(key)) {
                zwieschen += sumI;
            }
            if (maxCategorySum < zwieschen) {
                maxCategorySum = zwieschen;
                maxCategoryName = key;
            }
        }
        return maxCategoryName;
    }
}