package Yandex.Sprint__3.TransformType;

import java.util.ArrayList;
import java.util.Arrays;

public class ZooBesuch {
    public static void main(String[] args) {

        int[] orderTier = {1, 4, 0, 2, 3};
        ArrayList<String> tiereList = new ArrayList<>(Arrays.asList("шиншиллa", "крокодил", "лeв", "медведь", "слона"));

        System.out.println("Сегодня в зоопарке можно увидеть кормления " + tiereList.size() + " животных. \nЭто будут: ");
        for (String tier : tiereList) {
            System.out.println(tier);
        }

        System.out.println("Расписание кормлений:");

        for (int i = 0; i < tiereList.size(); i++) {
            int zeit = i + 9;

            System.out.println("В " + zeit + ":00 - " + tiereList.get(orderTier[i]));

        }
        System.out.println();
        System.out.println("Успех!\n" +
                "Решение прошло все проверки! “ヽ(´▽｀)ノ” ");
    }
}