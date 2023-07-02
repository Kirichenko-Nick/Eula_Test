

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P7_3 {
    public static void main(String[] args) {
        int start = 2; // Начальное значение диапазона
        int end = 100; // Конечное значение диапазона

        List<Integer> primeNumbers = findPrimeNumbers(start, end);

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        primeNumbers.forEach(System.out::println);
    }

    public static List<Integer> findPrimeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .allMatch(i -> number % i != 0))
                .boxed()
                .collect(Collectors.toList());
    }
}
