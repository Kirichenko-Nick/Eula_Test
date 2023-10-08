package JavaMit;

import java.util.*;

public class BinaruSeatch_Example {
    public static void main(String[] args) {

        ArrayList <Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(-52);
        arr.add(3);
        arr.add(-1);
        arr.add(-11);
        arr.add(10000);
        Collections.sort(arr);
        int index1 = Collections.binarySearch(arr, 10000);
        System.out.println(index1);
        System.out.println(index1 + "  " +  arr.get(index1));




    }
}
