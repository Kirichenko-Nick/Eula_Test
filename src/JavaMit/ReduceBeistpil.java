package JavaMit;

import java.util.ArrayList;
import java.util.List;

public class ReduceBeistpil {


    public static void main(String[] args) {


        List <Integer> integerList = new ArrayList<>(){{add(5); add(8); add(2); add(4);}};

        int result = integerList.stream().reduce((accumulator, el) -> accumulator * el).get();
        System.out.println(result);



    }
}
