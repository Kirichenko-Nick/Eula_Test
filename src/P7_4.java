
import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;

public class P7_4 {
    public static void main(String[] args) {
        int start = 2; // Начальное значение диапазона
        int end = 10001; // Конечное значение диапазона

        List<Integer> primeNumbers = findPrimeNumbers(start, end);

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        primeNumbers.forEach(System.out::println);
    }

    public static List<Integer> findPrimeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(P7_4::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(i -> number % i != 0);
    }
}
