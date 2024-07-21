package Yandex.Sprint_1;

import java.util.Scanner;

public class A1_PiyyaTrefpunkt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many slices is the pizza cut into?");
        int slicesInPizza = scanner.nextInt();
        System.out.println("How many pieces does one meeting attendee eat?");
        int slicesToPerson = scanner.nextInt();
        int numOfPizzas = 2; // The perfect amount of pizza   ヽ(´▽｀)ノ
        int totalSlices = numOfPizzas * slicesInPizza;
        int maximumPeopleToMeeting = totalSlices / slicesToPerson;
        int leftSlices = totalSlices % maximumPeopleToMeeting;
        System.out.println("Maximum number of participants in an ideal meeting: " + maximumPeopleToMeeting);
        System.out.println("There will be pizza slices left: " + leftSlices);
        scanner.close();
    }

}