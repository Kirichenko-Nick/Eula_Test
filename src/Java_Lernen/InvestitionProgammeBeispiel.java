package Java_Lernen;
import java.util.Scanner;
public class InvestitionProgammeBeispiel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Курсы валют (условные, для примера)
        final double USD_TO_RUB = 75.0;
        final double EUR_TO_RUB = 90.0;
        final double CNY_TO_RUB = 12.0;

        // Процентная ставка (годовая)
        final double INTEREST_RATE = 0.05;

        // Ввод валюты
        System.out.println("Выберите валюту: ");
        System.out.println("1. Рубли");
        System.out.println("2. Доллары");
        System.out.println("3. Евро");
        System.out.println("4. Юани");
        int currencyChoice = scanner.nextInt();

        String currency;
        double conversionRate = 1.0;

        switch (currencyChoice) {
            case 2:
                currency = "доллары";
                conversionRate = USD_TO_RUB;
                break;
            case 3:
                currency = "евро";
                conversionRate = EUR_TO_RUB;
                break;
            case 4:
                currency = "юани";
                conversionRate = CNY_TO_RUB;
                break;
            case 1:
            default:
                currency = "рубли";
                currencyChoice = 1; // установка по умолчанию
                break;
        }


        // Ввод начальной суммы
        System.out.print("Введите начальную сумму в " + currency + ": ");
        double initialAmount = scanner.nextDouble();

        // Ввод количества лет
        System.out.print("Введите количество лет для расчёта: ");
        int years = scanner.nextInt();




        // Расчет итоговой суммы с учетом сложного процента и бонусов
        double finalAmount = initialAmount;

        for (int i = 1; i <= years; i++) {
            finalAmount += finalAmount * INTEREST_RATE;
            if (i % 3 == 0) {
                finalAmount += finalAmount * 0.01; // бонус через каждые три года
            }
        }

        // Конвертация в рубли, если валюта отличается от рублей
        if (currencyChoice != 1) {
            finalAmount *= conversionRate;
        }

        System.out.printf("Итоговая сумма по окончании периода: %.2f рублей\n", finalAmount);
        System.out.println("Программа завершена.");

        scanner.close();
    }
}


