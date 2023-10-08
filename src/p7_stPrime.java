import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class p7_stPrime {
    public static void main(String[] args) {


        List <Integer> list = new ArrayList<>();
        int start = 2; // Начальное значение диапазона
        int end = 1000; // Конечное значение диапазона

        System.out.println("Список простых чисел от " + start + " до " + end + ":");
        IntStream.rangeClosed(start, end)
                .filter(p7_stPrime::isPrime)
               // .filter(p7_stPrime::test)
                .forEach(System.out::println);

        System.out.println(start );


    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }

    public static boolean test(int i) {
        return i > 102 && i < 200;
    }

}


