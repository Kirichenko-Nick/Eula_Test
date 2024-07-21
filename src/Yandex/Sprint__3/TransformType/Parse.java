package Yandex.Sprint__3.TransformType;

public class Parse {
    public static void main(String[] args) {

        String input = "1000.55";
        int number = (int) Float.parseFloat(input);
        System.out.println(number);
        String firstNumber = "123.45";
        String secondNumber = "234.56";
        System.out.println(addNumbers(firstNumber, secondNumber));

        System.out.println();

        long a = 142_858_234;
        long b = 9_123_456_678L;
        long maximum = Long.max(a, b);
        System.out.println("Максимальное значение - " + maximum);

    }


    private static Float addNumbers(String firstNumber, String secondNumber) {
        return Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
    }

}
