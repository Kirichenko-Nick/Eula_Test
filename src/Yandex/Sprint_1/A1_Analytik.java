package Yandex.Sprint_1;

import java.util.Scanner;

public class A1_Analytik {

    public static void main(String[] args) {
        double[] expenses = new double[7];
        double rateUSD = 94.8;
        double rateEUR = 103.8;
        double rateCNY = 13.1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("How much money do you have left until payday?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("How many days until payday?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            System.out.println("ЧWhat you want to do?");
            System.out.println("1 - Convert currency");
            System.out.println("2 - Get advice");
            System.out.println("3 - Enter. spend");
            System.out.println("4 - Show spending for the week");
            System.out.println("5 — Show the highest amount of spending for the week");
            System.out.println("0 - Output");

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Your savings " + moneyBeforeSalary + "RUB");
                System.out.println("What currency do you want to convert to? Available options: 1 - USD, 2 - EUR, 3 - CNY.");
                int currency = scanner.nextInt();
                if (currency == 1) {
                    System.out.println("Your savings in dollars: " + moneyBeforeSalary / rateUSD);
                } else if (currency == 2) {
                    System.out.println("Your savings in euros: " + moneyBeforeSalary / rateEUR);
                } else if (currency == 3) {
                    System.out.println("our savings in RMB: " + moneyBeforeSalary / rateCNY);
                } else {
                    System.out.println("An unknown currency has been introduced.");
                }
            } else if (command == 2) {
                if (moneyBeforeSalary < 3000) {
                    System.out.println("It's better to eat at home. Save money and you'll make it to payday!");
                } else if (moneyBeforeSalary < 10000) {
                    if (daysBeforeSalary < 10) {
                        System.out.println("You can order a pizza!");
                    } else {
                        System.out.println("It's better to eat at home today. Save money and you'll make it to payday!");
                    }
                } else if (moneyBeforeSalary < 30000) {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Not bad! We can have dinner at the cafe tonight. :)");
                    } else {
                        System.out.println("You can order a pizza!");
                    }
                } else {
                    if (daysBeforeSalary < 10) {
                        System.out.println("That's great! We can go to a restaurant.");
                    } else {
                        System.out.println("Not bad! We can have dinner at the cafe tonight.  :)");
                    }
                }
            } else if (command == 3) {
                System.out.println("For which day you want to enter spending:  1-MO, 2-DI, 3-MI, 4-DO, 5-FR, 6-SA, 7-SO?");
                int day = scanner.nextInt();
                System.out.println("Enter the amount of the spend:");
                double expense = scanner.nextDouble();
                moneyBeforeSalary = moneyBeforeSalary - expense;
                expenses[day - 1] = expenses[day - 1] + expense;
                System.out.println("The value has been saved! Your current balance in roubles " + moneyBeforeSalary);
                if (moneyBeforeSalary < 1000) {
                    System.out.println("There's not much left in your account. It's worth it to start saving!");
                }
            } else if (command == 4) {
                for (int i = 0; i < expenses.length; i++) {
                    System.out.println("Day " + (i + 1) + ". Spent  " + expenses[i] + " roubles");
                }
            } else if (command == 5) {

                double maxExpense = 0;

                for (int i = 0; i < expenses.length; i++) {
                    if (maxExpense < expenses[i]) {
                        maxExpense = expenses[i];
                    }
                }
                System.out.println("The largest amount spent this week was  " + maxExpense + " rubs.");

            } else if (command == 0) {
                System.out.println("Output");
                scanner.close();
                break;
            } else {
                System.out.println("Sorry, there's no such team yet.");
            }
        }
    }
}