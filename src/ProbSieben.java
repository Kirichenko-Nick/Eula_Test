
import java.util.ArrayList;
import java.util.List;

public class ProbSieben {
    public static void main(String[] args) {
        int start = 2; // Начальное значение диапазона
        int end = 100; // Конечное значение диапазона

        List<Integer> primes = new ArrayList<>();
        int i = 2;
        while (primes.size() < 10001) {
            if (isPrime(i)) {
                primes.add(i);
            }
            i++;
        }
        for (int primeNumber : primes) {
            System.out.print(primeNumber + " ");
        }
        System.out.println( "\n" +"primes: " + primes.get(primes.size() - 1));
        System.out.println(primes.size());

        List<Integer> primeNumbers = findPrimeNumbers(start, end);

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        for (int primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println("");
        System.out.println(primeNumbers.size());
    }

    public static List<Integer> findPrimeNumbers(int start, int end) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers;
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
