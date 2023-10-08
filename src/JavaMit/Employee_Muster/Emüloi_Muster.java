package JavaMit.Employee_Muster;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable <Employee> {

    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee_Muster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo (Employee o) {

        int result = this.id -o.id;
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        return result;
    }





    public static void main(String[] args) {
        Employee emp1 = new Employee(0, "Petr", 500);
        Employee emp2 = new Employee(5, "Ivam", 100);
        Employee emp3 = new Employee(3, "Tim", 150);
        Employee emp4 = new Employee(66, "Han", 500);
        Employee emp5 = new Employee(36, "Lin", 1420);
        Employee emp6 = new Employee(19, "Libibkon", 501420);
        Employee emp7 = new Employee(999, "Vasja", 142051050);

        List<Employee> employeeList_0 = new ArrayList<>();

        employeeList_0.add(emp1);
        employeeList_0.add(emp2);
        employeeList_0.add(emp3);
        employeeList_0.add(emp4);
        employeeList_0.add(emp5);
        employeeList_0.add(emp6);
        employeeList_0.add(emp6);

        List<Employee> employeeList = List.of(emp1, emp2, emp3, emp4, emp5,emp6, emp7);

        System.out.println(employeeList_0);

        Collections.sort(employeeList_0);

        System.out.println();

        System.out.println(employeeList_0);

        int index2 = Collections.binarySearch(employeeList_0, new Employee(19, "Libibkon", 501420));
        System.out.println(index2);


    }
}