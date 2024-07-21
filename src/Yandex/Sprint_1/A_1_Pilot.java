
package Yandex.Sprint_1;

import java.util.HashMap;
import java.util.Random;


public class A_1_Pilot {
    public static void main(String[] args) {
        Random random = new Random(); // генерирует случайное число
        int secretCode;
        int pilotInput;
        int i = 0;

        // добавьте цикл - ракета летает бесконечно
        while (true) {
            i++;
            secretCode = random.nextInt(3); // здесь задаётся код - случайное число от 0 до 100
            System.out.println("Ракета SpaceY на орбите!");
            pilotInput = random.nextInt(3); // пилот пытается угадать код

            if (secretCode == pilotInput) { // если пилот угадал код, то цикл должен завершиться
                System.out.println("Пилот угадал число! Домой!  с раза - " + i);
                break;
            }
        }
        // Инициализация HashMap для хранения переменных с счетчиками
        HashMap<String, Integer> counters = new HashMap<>();

        // Пример данных, которые будут обрабатываться в цикле
        String[] data = {"var1", "var2", "var3", "var1", "var2", "var1"};

        // Инициализация индекса для цикла while
        int j = 0;

        // Цикл while для обработки данных
        while (j < data.length) {
            String var = data[j];

            // Проверяем, существует ли переменная в HashMap
            if (counters.containsKey(var)) {
                // Если существует, увеличиваем счетчик на 1
                counters.put(var, counters.get(var) + 1);
            } else {
                // Если не существует, инициализируем переменную со значением 1
                counters.put(var, 1);
            }

            // Увеличиваем индекс для перехода к следующему элементу массива
            j++;
        }

        // Выводим результаты
        for (String key : counters.keySet()) {
            System.out.println(key + ": " + counters.get(key));
        }


        // unreachable statement
    }
}
