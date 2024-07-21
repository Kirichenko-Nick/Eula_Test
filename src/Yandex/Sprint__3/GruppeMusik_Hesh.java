package Yandex.Sprint__3;

import java.util.HashMap;
import java.util.Scanner;

public class GruppeMusik_Hesh {
    public static void main(String[] args) {
        HashMap<String, Integer> musicGroups = new HashMap<>();
        // объявите и проиницализируйте хеш-таблицу musicGroups

        musicGroups.put("The Beatles", 1960);
        musicGroups.put("Rammstein", 1994);
        musicGroups.put("Queen", 1970);
        musicGroups.put("Led Zeppelin", 1968);
        musicGroups.put("Black Sabbath", 1968);
        musicGroups.put("AC/DC", 1973);
        musicGroups.put("The Rolling Stones", 1962);
        musicGroups.put("The Who", 1964);
        musicGroups.put("Nightwish", 1996);
        musicGroups.put("Nirvana", 1987);
        musicGroups.put("Guns N’ Roses", 1985);
        musicGroups.put("Scorpions", 1965);
        musicGroups.put("Kiss", 1973);
        musicGroups.put("The Doors", 1965);

        System.out.println("Легендарные группы, год основания которых вы можете узнать:");

        for (String name : musicGroups.keySet()) {
            System.out.println(name);
        }


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите опцию");
            System.out.println("1 - Узнать год основания группы");
            System.out.println("2 - Добавить любимую группу");
            System.out.println("3 - Выйти из приложения");

            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите название группы");
                String keyGroup = scanner.next();// keyGroup

                System.out.println("Год основания " + keyGroup);
                int year = musicGroups.get(keyGroup);
                System.out.println(year);

            } else if (command == 2) {
                System.out.println("Добавьте свою любимую группу");
                System.out.println("Введите её название");
                String nameGroup = scanner.next();

                System.out.println("Введите год основания");
                int bornYear = scanner.nextInt();// year
                musicGroups.put(nameGroup, bornYear);
                System.out.println("Информация о группе " + nameGroup + " добавлена.");
                System.out.println();
            } else if (command == 3) {

                break;  // остановите цикл
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}