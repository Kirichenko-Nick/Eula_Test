
import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;

public class P7_2 {
    public static void main(String[] args) {
        int start = 2; // Начальное значение диапазона
        int end = 100; // Конечное значение диапазона

        List<Integer> primeNumbers = findPrimeNumbers(start, end);

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        primeNumbers.forEach(System.out::println);
    }

    public static List<Integer> findPrimeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(P7_2::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
