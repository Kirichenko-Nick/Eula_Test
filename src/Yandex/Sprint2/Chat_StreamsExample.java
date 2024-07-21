package Yandex.Sprint2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chat_StreamsExample {

    public static void main(String[] args) {
        // Исходный список строк
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Apricot");


        // Преобразование всех строк, которые начинаются с 'a', в верхний регистр и сбор в новый список
        List<String> upperCaseList = list.stream()
                .filter(s -> s.startsWith("a")) // Фильтрация строк, которые начинаются с 'a'
                .map(String::toUpperCase)       // Преобразование каждой строки в верхний регистр
                .sorted()                       // Сортировка строк в алфавитном порядке
                .collect(Collectors.toList());  // Сбор результата в новый список

        // Вывод результата
        upperCaseList.forEach(System.out::println);

        List<String> louCaseList = list.stream()
                .filter(s -> s.startsWith("D"))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
        louCaseList.forEach(System.out::println);
    }
}


