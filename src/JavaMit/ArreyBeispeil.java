package JavaMit;
// https://www.softwaretestinghelp.com/java-list-how-to-create-initialize-use-list-in-java/#:~:text=A%20new%20method%20is%20introduced,The%20list%20constructed%20is%20immutable.

import java.util.*;

public class ArreyBeispeil {

    public static void main(String[] args) {

        String[] strArray = {"Delhi", "Mumbai", "Kolkata", "Chennai"};
        //initialize an immutable list from array using asList method
        List<String> mylist = Arrays.asList(strArray);
        //print the list
        System.out.println("Immutable list:");
        for (String val : mylist) {
            System.out.print(val + " ");
        }
        System.out.println("\n");
        //initialize a mutable list(arraylist) from array using asList method
        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));
        System.out.println("Mutable list:");
        //add one more element to list
        arrayList.add("Pune");
        //print the arraylist
        for (String val : arrayList) {
            System.out.print(val + " ");
        }
        // ArrayList.add method
        List<String> str_list = new ArrayList<String>();
        str_list.add("Java");
        str_list.add("C++");
        System.out.println("ArrayList : " + str_list.toString());

        // LinkedList.add method
        List<Integer> even_list = new LinkedList<Integer>();
        even_list.add(2);
        even_list.add(4);
        System.out.println("LinkedList : " + even_list.toString());

        // double brace initialization - use add with declaration & initialization
        List<Integer> num_stack = new Stack<Integer>() {{
            add(10);
            add(20);
        }};
        System.out.println("Stack : " + num_stack.toString());

/*

        List<dataType> listname = Collections.EMPTY_LIST;
        Collections.addAll(listname = new ArrayList<datatype>(), values…);

        List<datatype> listname =
        Collections.unmodifiableList(Arrays.asList(values…));
*/


        // empty list
        List<Integer> list = new ArrayList<Integer>();

        // Instantiating list using Collections.addAll()
        Collections.addAll(list, 10, 20, 30, 40);

        // Print the list
        System.out.println("List with addAll() : " + list.toString());

        // Create& initialize the list using unmodifiableList method
        List<Integer> intlist = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 7));

        // Print the list
        System.out.println("List with unmodifiableList(): " + intlist.toString());

        // Create& initialize the list using singletonList method
        List<String> strlist = Collections.singletonList("Java");

        // Print the list
        System.out.println("List with singletonList(): " + strlist.toString());

        //initialize a string list
        List<String> list1 = new ArrayList<String>() {{
            add("Python");
            add("C++");
            add("Java");
        }};
        // string representation of list using toString method
        System.out.println("List contents using toString() method:" + list1.toString());


        //string list
        List<String> list3 = Arrays.asList("Java", "Python", "C++", "C", "Ruby");
        //print list3 using for loop
        System.out.println("List contents using for loop:");
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.get(i) + " ");
        }
        //print list3 using enhanced for loop
        System.out.println("\n\nList contents using enhanced for loop:");
        for (String s : list3) {
            System.out.print(s + " ");
        }

        //list of odd numbers
        List<Integer> oddlist = Arrays.asList(1,3,5,7,9,11);

        // using List.toArray() method
        System.out.println("Contents of list converted to Array:");
        System.out.println(Arrays.toString(oddlist.toArray()));

        //list of even numbers
        List<Integer> evenlist = Arrays.asList(2,4,6,8,10,12,14);
        // print list using streams
        System.out.println("Contents of evenlist using streams:");
        evenlist.stream().forEach(S ->System.out.print(S + " "));





    }
}








