package JavaMit;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {

        String s = "mada1m";
        List<Character> list;
        list = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> iterator_reverce = list.listIterator(list.size());
        boolean isPalindrome = true;
        int i = 0;

        while (iterator.hasNext() && iterator_reverce.hasPrevious()) {
            System.out.println(++i);
           // System.out.println(iterator_reverce.previous().toString());
            if (iterator.next() != iterator_reverce.previous()) {
                isPalindrome = false;
                System.out.println("inIf");
                break;

            }
            System.out.println("INcWhile");
        }


        System.out.println("NachWhile");

        System.out.println(isPalindrome + " Es ist heir : " + i);

        System.out.println(list);

        if (isPalindrome) {
            System.out.println("Polindrom");
        } else {
            System.out.println("Kein Polingdrom");
        }
    }
}
