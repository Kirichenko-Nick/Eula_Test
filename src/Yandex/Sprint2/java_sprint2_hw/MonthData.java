package Yandex.Sprint2.java_sprint2_hw;

/**
 * логика по подсчёту статистики за месяц;
 * хранение данных конкретного месяца
 */

public class MonthData {
    int daysInManth = 30;
    int[] days = new int[daysInManth];
    int month;

    MonthData(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Month ").append(month).append(":\n");
        for (int i = 0; i < days.length; i++) {
            sb.append(i + 1).append(" день: ").append(days[i]).append(" steps\n");
        }
        return sb.toString();
    }

    public void printDaysAndStepsFromMonth() {
        int summSteps = 0;
        for (int i = 0; i < days.length; i++) {
            summSteps += days[i];
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestsSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (goalByStepsPerDay <= days[i]) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }
}
