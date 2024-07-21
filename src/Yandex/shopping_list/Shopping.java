package Yandex.shopping_list;

/*So, you need to write a programme with a console interface that will be a digital shopping list. the programme must be able to perform four actions:
        add an item to the list,
        display the list,
        clear the list,
        terminate.
        After performing any of the first three actions, the programme should again offer a list of available actions. If you select "finish the job", it should stop.*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shopping {

/*    public static boolean contains(String[] arraySale, String inputLine) {
        return Arrays.stream(arraySale1).anyMatch(inputLine::equals);
    }*/

    public static void main(String[] args) {
        int productCount = 0;
        int maxSize = 2;
        String[] shoppingList = new String[maxSize];
        boolean isStart = false;
        String inputLine = "";

        System.out.println("A shopping list welcomes you!");
        Scanner scanner = new Scanner(System.in);

        while (!isStart) {
            System.out.println("Select one of the commands:");
            System.out.println("1. Add item to the list");
            System.out.println("2. Show list");
            System.out.println("3. Clear the list");
            System.out.println("4. Finfish the work");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {

                if (productCount >= maxSize) {
                    maxSize *= 2;
                    String[] shoppingListNew = new String[maxSize];
                    for (int i = 0; i < shoppingList.length; i++) {
                        shoppingListNew[i] = shoppingList[i];
                    }
                    shoppingList = shoppingListNew;
                }

                System.out.println("Need to maintain the name of a new product: ");
                scanner.nextLine();
                inputLine = scanner.nextLine();

                // boolean result = contains(shoppingList, inputLine);

                boolean result = false;

                for (String line : shoppingList
                ) {
                    result = inputLine.equals(line);
                    break;
                }

                if (result) {
                    System.out.println("This item is already on the list!");
                    result = false;
                } else {
                    shoppingList[productCount] = inputLine;
                    productCount++;
                    System.out.println("The product has been added to the list under the number " + productCount);
                }
                /*else {

                    System.out.println(" Please postpone your purchase until next time.");
                }*/

            } else if (actionNumber == 2) {

                if (productCount > 0) {

                    //System.out.println("The following products are listed:" + Arrays.stream(shoppingList).toList());
                    //System.out.println("The following products are listed: " + Arrays.stream(shoppingList, 0, productCount).collect(Collectors.joining(", ")));

                    System.out.println("The following products are listed:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                } else {
                    System.out.println("Product list ist empty.");
                }

            } else if (actionNumber == 3) {
                for (int i = 0; i < shoppingList.length; i++) {
                    shoppingList[i] = null;
                }
                productCount = 0;
                System.out.println("Product list ist empty!");

            } else if (actionNumber == 4) {
                isStart = true;
                //break;
            } else {
                System.out.println("Unknown command!");
            }
        }
        System.out.println("The programme has completed its work!");
        scanner.close();
    }
}


