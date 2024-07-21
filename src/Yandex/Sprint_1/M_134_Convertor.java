package Yandex.Sprint_1;

import java.util.Scanner;

public class M_134_Convertor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Сколько денег у вас осталось.");
        double moneyBeforeSalary = scanner.nextDouble();


        System.out.println("Выберете вариант программы:\n конвертация - convert,\n совет по питанию - advice.");
        String command = scanner.next();

        if (command.equalsIgnoreCase("convert")) {


            double rateUSD = 88.7604;
            double rateEUR = 96.5698;
            double rateCNY = 12.2251;
            double rateKonvert = 0;

            System.out.println("Введите тип валюты:");
            System.out.println("Доллар – USD;");
            System.out.println("Евро – EUR;");
            System.out.println("Юань– CNY.");

            String currency = scanner.next();


            if (currency.equalsIgnoreCase("USD")) {
                rateKonvert = moneyBeforeSalary / rateUSD;
                System.out.println("Было введено " + moneyBeforeSalary + ", в долларах это " + rateKonvert);
            } else if (currency.equalsIgnoreCase("EUR")) {
                rateKonvert = moneyBeforeSalary / rateEUR;
                System.out.println("Было введено " + moneyBeforeSalary + ", в евро это " + rateKonvert);
            } else if (currency.equalsIgnoreCase("CNY")) {
                rateKonvert = moneyBeforeSalary / rateCNY;
                System.out.println("Было введено " + moneyBeforeSalary + ", в юанях это " + rateKonvert);
            } else {
                System.out.println("Введена неизвестная валюта.");
                return;
            }
        } else if (command.equalsIgnoreCase("advice")) {


            System.out.println("До зарплаты сколько дней");
            int daysBeforeSalary = scanner.nextInt();


            if (moneyBeforeSalary < 3000) {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            } else if (moneyBeforeSalary >= 3000 && moneyBeforeSalary < 10000) {
                if (daysBeforeSalary < 10) {
                    System.out.println("Можно заказать пиццу!");
                } else {
                    System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                }
            } else if (moneyBeforeSalary >= 10000 && moneyBeforeSalary < 30000) {
                if (daysBeforeSalary < 10) {
                    System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
                } else {
                    System.out.println("Можно заказать пиццу!");
                }
            } else {
                if (daysBeforeSalary < 10) {
                    System.out.println("Отлично! Можно сходить в ресторан.");
                } else {
                    System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
                }
            }
        } else {
            System.out.println("Извините, такой команды пока нет.");
        }

        scanner.close();
        System.out.println("Работа с программой завершена.");
    }
}
