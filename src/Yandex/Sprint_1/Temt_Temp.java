package Yandex.Sprint_1;

import java.util.Arrays;
import java.util.Scanner;

public class Temt_Temp {


    public static void main(String[] args) {

        String[] d = {"s", "d"};
        String[] g = new String[1];
        g = d;
        System.out.println(Arrays.stream(d).toList());
        System.out.println(Arrays.stream(g).toList());

    }
}