package Java_Lernen;




import java.util.Scanner;
public class Soluction_1 {
    public static void main(String[] args)
    {
       /* Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        int age = console.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
*/
        int number = 15;

        if (number % 2 == 0) {
            System.out.print("к");
        } else {
            System.out.print("н");
        }

        System.out.print("о");

        number = 15 - (10 / 2);
        if (number > 10) {
            System.out.print("м");
        } else {
            System.out.print("р");
        }

        number = 10;
        if (number == 10) {
            System.out.print("а");
        } else {
            System.out.print("п");
        }
    }
}