




import java.util.ArrayList;
        import java.util.List;

public class P3_LargestPrimeFactor {
    public static void main(String[] args) {
        long number = 600851475143L; // Число, для которого нужно найти наибольший простой множитель

        List<Long> primeFactors = findPrimeFactors(number);

        if (!primeFactors.isEmpty()) {
            long largestPrimeFactor = primeFactors.get(primeFactors.size() - 1);
            System.out.println("Наибольший простой множитель числа " + number + " равен: " + largestPrimeFactor);
        } else {
            System.out.println("У числа " + number + " нет простых множителей.");
        }
    }

    public static List<Long> findPrimeFactors(long number) {
        List<Long> primeFactors = new ArrayList<>();

        while (number % 2 == 0) {
            primeFactors.add(2L);
            number /= 2;
        }

        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }
}
