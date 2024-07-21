package Java_Lernen;
import java.util.Scanner;
public class NestedIfElseExample {

        public void main(String[] args) {



            String i = "Halloo";
            boolean x = i.equals("Halloo");
            System.out.println(x);
            int temperature = 25;

            if (temperature > 0) {
                int humidity = 70;

                if (humidity > 60) {
                    int dryHeatIndex = temperature + humidity;

                    if (dryHeatIndex > 80) {
                        System.out.println("Предупреждение о жаре! Индекс тепла составляет: " + dryHeatIndex);
                    } else {
                        System.out.println("Индекс тепла составляет: " + dryHeatIndex);
                    }
                } else {
                    int windChillIndex = temperature - humidity;

                    if (windChillIndex < -10) {
                        System.out.println("Предупреждение о сильном холоде! Индекс ощущаемой температуры составляет: " + windChillIndex);
                    } else {
                        System.out.println("Индекс ощущаемой температуры составляет: " + windChillIndex);
                    }
                }
            } else {
                int humidity = 80;

                if (humidity > 75) {
                    int wetHeatIndex = temperature + humidity;

                    if (wetHeatIndex > 90) {
                        System.out.println("Предупреждение о жаре! Индекс тепла составляет: " + wetHeatIndex);
                    } else {
                        System.out.println("Индекс тепла составляет: " + wetHeatIndex);
                    }
                    // >> К каким переменным можно обратиться в этом месте?
                } else {
                    int windChillIndex = temperature - humidity;

                    if (windChillIndex < -20) {
                        System.out.println("Предупреждение о сильном холоде! Индекс ощущаемой температуры составляет: " + windChillIndex);
                    } else {
                        System.out.println("Индекс ощущаемой температуры составляет: " + windChillIndex);
                    }
                }
            }
        }}


