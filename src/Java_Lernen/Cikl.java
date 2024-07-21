package Java_Lernen;

public class Cikl {
    public static void main(String[] args) {
        int a = 1;
        while (a <= 3) {
            System.out.println( "\n  versuch %" + a);
            for (int i = 1; i <= 5; i = i + 1) {
                System.out.println("Байт съел " + i + "-ю морковку");
            }
            a++;

        }

    }
}
