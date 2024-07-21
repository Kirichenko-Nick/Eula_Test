package Java_Lernen;
import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rateUSD = 88.7604 ;
        double rateEUR = 96.5698 ;
        double rateCNY = 12.2251;
        double rateKonvert = 0;


        System.out.println("Введите сумму рублей для конвертации:");
      double command  =scanner.nextDouble();

        if (command > 0){
            System.out.println("Введите номер валюты, в какую перевести рубли:");
            System.out.println("1 – доллары;");
            System.out.println("2 – евро;");
            System.out.println("3 – юани;");

            int valuta  = scanner.nextInt();


            if ( valuta == 1){

                rateKonvert = command / rateUSD;
                if (rateKonvert > 0){
                    System.out.println("Было введено " + command  + " рублей, в долларах это " + rateKonvert);
                }
                else {
                    System.out.println("Ошибка: некорректные значения.");
                }
            }  else if ( valuta == 2){
                rateKonvert = command /  rateEUR;
                if (rateKonvert > 0){
                    System.out.println("Было введено " + command  + " рублей, в евро это " + rateKonvert);
                }
                else {
                    System.out.println("Ошибка: некорректные значения.");
                }



            }
            else if ( valuta == 3){
                rateKonvert = command/rateCNY;
                if (rateKonvert > 0){
                    System.out.println("Было введено " + command  + " рублей, в юанях это " + rateKonvert);
                }
                else {
                    System.out.println("Ошибка: некорректные значения.");
                }
            }
            else {
                System.out.println("Такой команды нет.");
            }
        } else {
            System.out.println("Ошибка: некорректные значения.");
        }
        System.out.println("Работа с программой завершена.");


    }
}