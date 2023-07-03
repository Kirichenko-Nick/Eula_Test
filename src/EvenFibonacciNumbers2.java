
// https://stackoverflow.com/questions/18927767/project-euler-2-in-java
// https://projecteuler.net/problem=2
// project euler problem 2
// https://www.nayuki.io/page/project-euler-solutions



import java.util.ArrayList;
import java.util.Arrays;

public class EvenFibonacciNumbers2 {

    public static void main(String[] args) {


        ArrayList<Integer> nummers = new ArrayList<>();
        Integer summ = 0;
        int count = 0;
        int a = 0;
        int b = 1;
        int c = 0;
        while (c < 4000000) {
            c = a + b;
            nummers.add(c);
            a = b;
            b = c;
            if (c % 2 == 0 ) {
                summ = summ + c;
                ++count;
            }

        }


        System.out.println("Es war count:" + count + " Summer ist : " + summ + " Arreys: " + nummers.toString());

        System.out.println( fibonacci(400));



    }


  static   public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

}




