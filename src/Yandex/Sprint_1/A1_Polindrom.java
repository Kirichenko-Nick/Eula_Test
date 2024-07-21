package Yandex.Sprint_1;

import java.util.ArrayList;

public class A1_Polindrom {
    public static void main(String[] args) {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        ArrayList<String> rev = new ArrayList<>();
        for (String s : words) {
            char[] array = s.toCharArray();
            String result = "";
            for (int i = array.length - 1; i >= 0; i--) {
                result = result + array[i];
            }
            if (s.equals(result)) {
                rev.add(s);
            }
        }
        System.out.println(rev);

    }
}
