package Yandex.Sprint_1;

import java.util.Scanner;

public class A1_Convertor1913 {
    public static void main(String[] args) {
        //мы подготовили эти прайс-лист
        String[] items1913 = {"Корова", "Курица", "Рубашка", "Шапка гусарская", "Гармонь", "Рояль"};
        String[] items1984 = {"Банка сгущёнки", "Мороженое", "Карта мира", "Кассетный магнитофон", "Пальто осеннее"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму в современных рублях:");
        int amount = scanner.nextInt();


        System.out.println("Введите год (1913 или 1984)");
        int year = scanner.nextInt();


        // это коэффициент для перевода рубля по курсу заданного года
        double koef = -1;

        switch (year) {
            case 1913:
                koef = 1 / 884.0;
                break;
            case 1984:
                koef = 1 / 337.0;
                break;

        }

        // курс рубля задан не для каждого года
        if (koef < 0) {
            System.out.println("Для этого года у нас нет данных.");
            koef = 0;
        }


        // переведите заданную сумму в рубли по старому курсу
        double amountByYear = amount * koef;

        System.out.println("В " + year + " году эта сумма приблизительно равнялась бы "
                + amountByYear + " р. "
                + "На эти деньги вы могли бы купить следующие товары:");

        // выведите товары, которые вам доступны
        switch (year) {
            case 1913:
                for (int i = 0; i < items1913.length; i++) {
                    String item = items1913[i];
                    Double price = 0.0;
                    switch (item) {
                        case "Корова":
                            price = 60.0;
                            break;
                        case "Курица":
                            price = 0.60;
                            break;
                        case "Рубашка":
                            price = 1.00;
                            break;
                        case "Шапка гусарская":
                            price = 12.00;
                            break;
                        case "Гармонь":
                            price = 7.50;
                            break;
                        case "Рояль":
                            price = 200.0;
                            break;
                    }
                    // расчитываем количество и приводим результат к целому числу
                    int quantity = (int) (amountByYear / price);
                    if (quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }

                break;
            case 1984:
                for (int i = 0; i < items1984.length; i++) {
                    String item = items1984[i];
                    Double price = 0.0;
                    switch (item) {
                        case "Банка сгущёнки":
                            price = 0.55;
                            break;
                        case "Мороженое":
                            price = 0.20;
                            break;
                        case "Карта мира":
                            price = 0.54;
                            break;
                        case "Кассетный магнитофон":
                            price = 95.00;
                            break;
                        case "Пальто осеннее":
                            price = 100.00;
                            break;

                    }
                    // расчитываем количество и приводим результат к целому числу
                    int quantity = (int) (amountByYear / price);
                    if (quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }
                break;
        }
    }
}

