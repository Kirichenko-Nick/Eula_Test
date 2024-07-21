package LitCode;
/*https://leetcode.com/problems/two-sum/solutions/5136300/an-easy-solution-for-java/*/


import java.util.Arrays;
import java.util.HashMap;

public class A2_TwoEquelsFinde {
    public static void main(String[] args) {

        int[] nums = {4, 3, 55, 4, 1};
        int target = 5;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println("--------------------");
        System.out.println(Arrays.toString(twoSumKomplex(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumKomplex(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
/*
    Хороший вопрос! Давайте детально рассмотрим, как используется хэш-карта (HashMap) и как проверяется наличие элемента в карте в контексте вашего метода.

        Когда мы создаем пустую хэш-карту, она действительно не содержит никаких элементов. В процессе выполнения цикла мы будем добавлять элементы в карту и одновременно проверять, содержится ли в карте элемент, который вместе с текущим элементом образует целевую сумму (target). Рассмотрим это пошагово.

        Подробное объяснение
        Инициализация хэш-карты:

        java
        Копировать код
        HashMap<Integer, Integer> map = new HashMap<>();
        Цикл по элементам массива:

        java
        Копировать код
        for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
        Пример с пояснениями
        Рассмотрим ваш пример с массивом nums = {2, 7, 11, 15} и target = 9.

        Первый шаг (i=0):

        Текущий элемент: nums[0] = 2
        Вычисляем complement = target - nums[0] = 9 - 2 = 7
        Проверяем, содержится ли 7 в карте: map.containsKey(7) возвращает false (карта пустая)
        Добавляем пару 2: 0 в карту: map.put(2, 0)
        Карта теперь выглядит так:

        Копировать код
        {2=0}
        Второй шаг (i=1):

        Текущий элемент: nums[1] = 7
        Вычисляем complement = target - nums[1] = 9 - 7 = 2
        Проверяем, содержится ли 2 в карте: map.containsKey(2) возвращает true (в карте есть 2)
        Поскольку 2 уже содержится в карте, и его индекс 0, возвращаем индексы: return new int[]{map.get(2), 1}
        Метод возвращает массив [0, 1], так как nums[0] + nums[1] = 2 + 7 = 9.

        Как карта заполняется и проверяется:
        Инициализация: Карта пустая.
        Шаг 1: Проверяем, есть ли 7 в карте (false), добавляем 2: 0.
        Шаг 2: Проверяем, есть ли 2 в карте (true), возвращаем результат.
        Важные моменты:
        Проверка containsKey: Каждую итерацию цикла проверяем, содержится ли complement в карте. Эта операция выполняется быстро, за амортизированное время
        𝑂
        (
        1
        )
        O(1).
        Добавление в карту: Если нужного элемента нет, добавляем текущий элемент массива и его индекс в карту.
        Таким образом, карта постепенно заполняется по мере итерации по массиву, и на каждом шаге проверяется, содержится ли комплемент текущего элемента в карте.*/