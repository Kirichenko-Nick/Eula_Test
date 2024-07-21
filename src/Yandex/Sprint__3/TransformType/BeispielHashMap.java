package Yandex.Sprint__3.TransformType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BeispielHashMap {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Double>> menu = new HashMap<>(); // создаём хеш-таблицу
        ArrayList<Double> mohitoPrice = new ArrayList<>();
        // создаём список с ценами для коктейля
        mohitoPrice.add(350.0);  // добавляем в список цену в рублях
        mohitoPrice.add(15.50);  // добавляем в список цену в долларах
        mohitoPrice.add(13.20);  // добавляем в список цену в евро
        menu.put("Коктейль Mojito", mohitoPrice); // добавляем коктейль и список ценами в хеш-таблицу

        ArrayList<Double> tiramisuPrice = new ArrayList<>();  // создаём список с ценами для тирамису
        tiramisuPrice.add(120.0);
        tiramisuPrice.add(4.00);
        tiramisuPrice.add(3.20);
        menu.put("Тирамису", tiramisuPrice); // добавляем тирамису и список с ценами в хеш-таблицу

        ArrayList<Double> ramenPrice = new ArrayList<>(); // создаём список с ценами для рамена
        ramenPrice.add(230.0);
        ramenPrice.add(8.50);
        ramenPrice.add(7.00);
        menu.put("Рамен", ramenPrice); // добавляем рамен и список с ценами в хеш-таблицу
        System.out.println(menu);

        ramenPrice.remove(7.00);
        System.out.println(menu);


        System.out.println();


        HashMap<String, ArrayList<Integer>> stateHolidays = new HashMap<>();


        stateHolidays.put("Январь", new ArrayList<>(Arrays.asList(1, 7)));
        stateHolidays.put("Февраль", new ArrayList<>(Arrays.asList(23)));
        stateHolidays.put("Март", new ArrayList<>(Arrays.asList(8)));
        stateHolidays.put("Май", new ArrayList<>(Arrays.asList(1, 9)));
        stateHolidays.put("Июнь", new ArrayList<>(Arrays.asList(12)));
        stateHolidays.put(" Ноябрь ", new ArrayList<>(Arrays.asList(4)));


        System.out.println(stateHolidays);


        // todo Ссылка на урок: [Спринт 3/9: 3 → Тема 3/9: Введение в коллекции → Урок 8/10: Операции с хеш-таблицами](https://practicum.yandex.ru/trainer/java-developer/lesson/56f611f6-e1d5-4725-9b93-f27abca5e7da/)
        // todo Не удалаяется по значению - как удалить и почему так?

        System.out.println(stateHolidays);
        System.out.println("Решение прошло все проверки! “ヽ(´▽｀)ノ” ");


        // Ключ и значение, которые хотим удалить
        String key = "Май";
        Integer valueToRemove = 9;

        // Удаляем значение из ArrayList по ключу
        stateHolidays.getOrDefault(key, new ArrayList<>()).removeIf(val -> val.equals(valueToRemove));

        // Выводим результат
        System.out.println(stateHolidays);


        // Значение, которое хотим удалить
        List<Integer> valueToRemove_1 = Arrays.asList(1, 9);

        // Удаляем записи, значение которых соответствует заданному
        stateHolidays.entrySet().removeIf(entry -> entry.getValue().equals(valueToRemove_1));

        // Выводим результат
        System.out.println(stateHolidays);

        // Ключ, старое значение и новое значение
        String key1 = "Май";
        Integer oldValue = 9;
        Integer newValue = 10;

        // Получаем ArrayList по ключу и заменяем старое значение новым
        stateHolidays.getOrDefault(key1, new ArrayList<>()).replaceAll(val -> val.equals(oldValue) ? newValue : val);

        // Выводим результат
        System.out.println(stateHolidays);

    }
}

