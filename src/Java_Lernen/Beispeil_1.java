package Java_Lernen;

import java.awt.*;
import java.nio.*;
import java.util.Scanner;




public class Beispeil_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет, "  + "! Введите:");
       // int totalPeople_1 = scanner.nextInt();
        String name = scanner.nextLine();
        int totalPeople =15;
String season = "winter";
int dancers = 0;
int gamePlayers =0;
int temperature = 14;
        if (season.equals("spring")) {

            System.out.println("Gehen Wandeln !!");

        } else if (temperature >15) {
            System.out.println("Пойдём в кафе на веранду!");

        } else if (dancers > 0) {
            System.out.println("Пойдём в бар!");

        }  else if (gamePlayers > 0) {
        System.out.println("ойдём к кому-то в гости и поиграем в настольные игры");

    } else {
            System.out.println("Смотрим в книгу!!!");
        }
    }
}

