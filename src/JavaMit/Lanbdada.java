package JavaMit;

// https://www.softwaretestinghelp.com/java-list-how-to-create-initialize-use-list-in-java/#:~:text=A%20new%20method%20is%20introduced,The%20list%20constructed%20is%20immutable.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lanbdada {
    static  void def (I i) {
        System.out.println(i.abc("Hallo999999"));
    }

    ;

    public static void main(String[] args) {


        def((String str) -> {return str.length();  });
        def( i -> i.length());

        System.out.println("-------------++++++++++++++-------------");

        Integer[] ko = {15, 55, 22, 265, 500, -1, 66};
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(ko));

        kq(arrayList);

    }

    public static void kq(List<Integer> s) {
        for (Integer i : s) {
            if (i > 15) System.out.println(i);

        }
    }

}

interface  I {
    int abc(String s);
}

