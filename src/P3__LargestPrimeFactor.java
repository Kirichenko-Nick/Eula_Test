
public class P3__LargestPrimeFactor {
    public static void main(String[] args) {
        // long number = 600851475143L; // Число, для которого нужно найти наибольший простой множитель
        long number = 6005; // Число, для которого нужно найти наибольший простой множитель

        long largestPrimeFactor = findLargestPrimeFactor(number);

        System.out.println("Наибольший простой множитель числа " + number + " равен: " + largestPrimeFactor);
    }

    public static long findLargestPrimeFactor(long number) {
        long largestPrimeFactor = 1;

        while (number % 2 == 0) {
            largestPrimeFactor = 2;
            number /= 2;
            System.out.println(" 1 "  +  number);
        }

        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                System.out.println("nummer3   " + number+" " + i);
                largestPrimeFactor = i;
                number /= i;
                System.out.println("4    " + number);
            }
        }

        if (number > 2) {
            largestPrimeFactor = number;
            System.out.println(largestPrimeFactor);
        }

        return largestPrimeFactor;
    }
}
