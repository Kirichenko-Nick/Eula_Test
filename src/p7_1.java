


import java.util.ArrayList;
import java.util.List;


public class p7_1 {


    public static void main(String[] args) {
        int start = 2; // Начальное значение диапазона
        int end = 100; // Конечное значение диапазона

        List<Integer> primeNumbers = findPrimeNumbers(start, end);

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        for (int primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
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
//1
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


