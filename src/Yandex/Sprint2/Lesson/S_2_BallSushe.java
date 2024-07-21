package Yandex.Sprint2.Lesson;

import java.util.Scanner;

public class S_2_BallSushe {

    public static void main(String[] args) {

        int balls = 15;

        // сохраните общее число мячиков Пикселя в переменной balls
        System.out.println("У Пикселя " + balls + " мячиков");

        playPixel(balls);
        // поиграйте с Пикселем, вызвав метод playPixel

        // после игры Пиксель должен вернуть все мячики на место!
        System.out.println("Пиксель вернул все мячики");
        System.out.println("Их снова " + balls);
    }

    public static void playPixel(int balls) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько мячиков спрятал Пиксель?");
        int hiddenBalls = scanner.nextInt();
        // сохраните количество мячиков, которые спрятал Пиксель, в переменную hiddenBalls

        balls = balls - hiddenBalls; // посчитайте, сколько у Пикселя осталось мячиков
        System.out.println("Осталось " + balls);
    }
}