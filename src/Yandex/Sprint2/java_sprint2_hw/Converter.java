package Yandex.Sprint2.java_sprint2_hw;

/**
 * преобразование шагов в килокалории и километры
 */

public class Converter {

    int stepLength;
    int stepKallorie;
    int kallorieToKillo;

    public Converter() {
        this.stepLength = 75;
        this.stepKallorie = 50;
        this.kallorieToKillo = 1000;
    }

    public int convertToKm(int steps) {
        int way = steps * stepLength / 100 / 1000;
        return way;
    }

    public int convertStepsToKilokalories(int steps) {
        int kalories = steps * stepKallorie / kallorieToKillo;
        return kalories;
    }
}
