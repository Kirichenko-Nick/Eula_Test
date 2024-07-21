package Yandex.Sprint2.Bankomat.infrastructura;

import Yandex.Sprint2.Bankomat.data.Card;

public class Application {
    public static void main(String[] args) {
        Card car = new Card("aa1", 50, "001");
        System.out.print(car.toString()); // todo Mach es Besser

    }

}
