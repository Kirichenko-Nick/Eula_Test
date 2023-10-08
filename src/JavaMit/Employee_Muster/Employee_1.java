package JavaMit.Employee_Muster;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Employee_1 {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        addToEmployeeList(employeeList, () -> new Employee(0, "Petr", 500));
        addToEmployeeList(employeeList, () -> new Employee(5, "Ivam", 100));
        addToEmployeeList(employeeList, () -> new Employee(3, "Tim", 150));
        addToEmployeeList(employeeList, () -> new Employee(66, "Han", 500));
        addToEmployeeList(employeeList, () -> new Employee(36, "Lin", 1420));
        addToEmployeeList(employeeList, () -> new Employee(19, "Libibkon", 501420));
        addToEmployeeList(employeeList, () -> new Employee(999, "Vasja", 142051050));

        System.out.println(employeeList);

    }

    private static void addToEmployeeList(List<Employee> list, Supplier<Employee> supplier) {
        Optional.ofNullable(supplier.get()).ifPresent(list::add);
    }
}
