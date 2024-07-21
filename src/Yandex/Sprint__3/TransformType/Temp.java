package Yandex.Sprint__3.TransformType;

import org.hamcrest.core.AllOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Testik[] intT = {new Testik(1, 2), new Testik(3, 4)};

        System.out.println(Arrays.stream(intT).toList());
        double[] expenses = new double[7];
        ArrayList<Double> expensesA = new ArrayList<>(10);

        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        // Можно даже создать список для хранения списков.
        

    }
}

class Testik {
    int intTest = 10;
    Integer integerTes = 20;

    public Testik(int intTest, Integer integerTest) {
        this.intTest = intTest;
        this.integerTes = integerTest;
    }

    @Override
    public String toString() {
        return "Testik{" +
                "intTest=" + intTest +
                ", integerTes=" + integerTes +
                '}';
    }
}