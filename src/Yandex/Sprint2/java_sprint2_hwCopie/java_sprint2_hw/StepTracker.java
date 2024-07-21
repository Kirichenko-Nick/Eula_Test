package Yandex.Sprint2.java_sprint2_hwCopie.java_sprint2_hw;

import java.util.Scanner;

/**
 * логика по сохранению количества шагов
 * (ввод месяца, дня, количества шагов и сохранение данных);
 * логика по изменению ежедневной нормы шагов; вывод статистики
 */


public class StepTracker {
    int goalByStepsPerDay;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        for (int monthNumber = 0; monthNumber < monthToData.length; monthNumber++) {
            this.monthToData[monthNumber] = new MonthData(monthNumber + 1);
        }
        this.goalByStepsPerDay = 10000;
        this.converter = new Converter();
    }


    public void printStatistic() {

        // количество пройденных шагов по дням;
        int currentMonth = chouceMonth();
        monthToData[currentMonth - 1].printDaysAndStepsFromMonth();

        // общее количество шагов за месяц;
        int sumStepsMonth = monthToData[currentMonth - 1].sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumStepsMonth);

        // максимальное пройденное количество шагов в месяце

        int maxSteps = monthToData[currentMonth - 1].maxSteps();
        System.out.println("Максимальное количество шагов в месяце: " + maxSteps);

        // среднее количество шагов;
        System.out.println("Cреднее количество шагов: " +
                (sumStepsMonth / monthToData[currentMonth - 1].daysInManth));

        // пройденная дистанция (в километрах);
        int distanceProMonth = converter.convertToKm(sumStepsMonth);
        System.out.println("Пройденная дистанция в километрах: " + distanceProMonth);

        // количество сожжённых килокалорий;
        int kaloriesProMonth = converter.convertStepsToKilokalories(sumStepsMonth);
        System.out.println("Количество сожжённых килокалорий: " + kaloriesProMonth);

        //лучшая серия: максимальное количество подряд идущих дней,
        // в течение которых количество шагов за день было равно или выше целевого.
        int besserSerieStets = monthToData[currentMonth - 1].bestsSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия мз дней подряд при достижению нормы шагов в день : " + besserSerieStets);
        System.out.println();


    }

    public void addNewNumberStepsPerDay() {
        while (true) {
            int numerMonth = chouceMonth();

            int nummerDay;
            while (true) {

                System.out.print("Введите номер дня (1-30): ");
                String cmdDay = scanner.nextLine();
                try {
                    nummerDay = Integer.parseInt(cmdDay);
                } catch (NumberFormatException e) {
                    System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно. " +
                            "А у Вас " + cmdDay);
                    continue;
                }
                if (nummerDay < 1 || nummerDay > 30) {
                    System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно. " +
                            "А у Вас " + cmdDay);
                    continue;
                }
                break;
            }

            while (true) {
                System.out.print("Введите количество шагов: ");
                String cmdSteps = scanner.nextLine();
                int nummerSteps;
                try {
                    nummerSteps = Integer.parseInt(cmdSteps);
                } catch (NumberFormatException e) {
                    System.out.println("Количество шагов должно быть положительным. " +
                            "А у Вас: " + cmdSteps);
                    continue;
                }
                if (nummerSteps < 0) {
                    System.out.println("Количество шагов должно быть положительным. " +
                            "А у Вас: " + cmdSteps);
                    continue;
                }

                monthToData[numerMonth - 1].days[nummerDay - 1] = nummerSteps;
                System.out.println("Данные успешно сохранены!");
                System.out.println();
                break;
            }

            break;
        }
    }

    public void printSteps() {
        int monthCheck = chouceMonth();

        monthToData[monthCheck].printDaysAndStepsFromMonth();
        for (MonthData monthData : monthToData) {
            System.out.println(monthData);
        }
    }

    public void changeStepGoal() {
        System.out.println("Устаноыите новую цель шагов на день: ");
        String cmdGoalSteps = scanner.nextLine();
        try {
            int goalBySteps = Integer.parseInt(cmdGoalSteps);
            if (goalBySteps <= 0) {
                System.out.println("Число шагов должно быть больше 0, а у Вас: "
                        + goalBySteps);
                System.out.println("Попробуйте снова.");
                return;
            }
            this.goalByStepsPerDay = goalBySteps;
            System.out.println("Ваша новая цель шагов на день: " + goalBySteps);
            System.out.println();

        } catch (NumberFormatException e) {
            System.out.println("Введите положительное число, а вы ввели "
                    + cmdGoalSteps);
            System.out.println("Попробуйте снова.");
            return;
        }
    }

    public int chouceMonth() {
        while (true) {
            System.out.print("Введите номер месяца (1-12): ");
            int nummerMonth;
            String cmdMonth = scanner.nextLine();
            try {
                nummerMonth = Integer.parseInt(cmdMonth);
            } catch (NumberFormatException e) {
                System.out.printf("Номер вводимого месяца должен быть от 1 до 12 включительно. " +
                        "А у Вас: %s\n", cmdMonth);
                continue;
            }
            if (nummerMonth < 1 || nummerMonth > 12) {
                System.out.printf("Номер вводимого месяца должен быть от 1 до 12 включительно. " +
                        "А у Вас: %s\n", cmdMonth);
                continue;
            }
            return nummerMonth;
        }
    }
}
