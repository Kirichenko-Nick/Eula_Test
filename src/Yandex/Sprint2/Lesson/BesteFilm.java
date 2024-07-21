package Yandex.Sprint2.Lesson;

public class BesteFilm {
    public static void main(String[] args) {
        // ниже вызовите новый метод
        String highestGrossingFilm = findHighestGrossingFilm();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);
    }

    public static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;

        // допишите реализацию метода ниже
        if (income1 > income2) {
            if (income1 > income3) {
                return film1;
            } else {
                return film3;
            }
        } else {
            if (income2 > income3) {
                return film2;
            } else {
                return film3;
            }
        }
    }
}
