package Yandex.Sprint__3.TransformType;

public class StackExample {


    public static void main(String[] args) {
        // 1. Создан новый блок стека — main
        // 2. Создаём переменную number
        int number = 5;
        // стек: {main: [number = 5]}
        // 3. Вызываем метод makePower. Передаём на вход переменную number и число 3
        // 9. Копируем значение, которое вернул метод makePower, в переменную result в блоке main
        int result = makePower(number, 5);
        // стек: {main: [number = 5, result = 125]}
        // 10. Выводим значения переменных result и number
        System.out.println("Результат вычисления степени: " + result);
        System.out.println("Значение inputNumber: " + number);
    }

    static int makePower(int number, int power) {
        // 4. Создан новый блок стека — makePower
        // 5. Созданы переменные number и power, в них скопированы значения 5 и 3
        // стек: {makePower: [number = 5, power = 3], main: [number = 5] }
        // 6. Создана переменная sourceNumber, копируем в неё значение 5 из переменной number
        // стек: {makePower: [number = 5, power = 3, sourceNumber = 5], main: [number = 5]}
        int sourceNumber = number;
        for (int i = 2; i <= power; i++) {
            // 7. Обновляем значение переменной number
            number = number * sourceNumber;
        }
        // стек: {makePower: [number = 125, power = 3, sourceNumber = 5], main: [number = 5] }
        // 8. Возвращаем значение переменной number
        return number;
    }
}