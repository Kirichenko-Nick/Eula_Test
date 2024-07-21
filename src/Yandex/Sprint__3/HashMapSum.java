package Yandex.Sprint__3;

import java.util.HashMap;

public class HashMapSum {
    public static void main(String[] args) {
        HashMap<String, Double> orders = new HashMap<>();
        orders.put("Иван И.", 4345.5);
        orders.put("Ольга С.", 76564.43);
        orders.put("Александр Т.", 1234.86);
        orders.put("Александр Р.", 23432.87);
        orders.put("Екатерина О.", 1034753.6);
        orders.put("Ярослав В.", 450.0);

        double summ = 0; // объявите переменную, где будет сохранена общая сумма
        for (Double tool : orders.values()) {
            summ += tool;
        }

        System.out.println("Всего было совершено заказов на сумму: " + summ);
    }
}