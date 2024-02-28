package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int employeesNumber = sc.nextInt();
        sc.nextLine();
        System.out.println();

        List<Employee> employee = new ArrayList<>();

        for (int i=1; i<=employeesNumber; i++) {

            System.out.println("Employee #" + i + ":");

            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();

            employee.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        sc.nextLine();

        int index = employee.indexOf(employee.stream().filter(e -> e.getId() == id).findFirst().orElse(null));

        if (index == -1) {
            System.out.println("This id does not exist!");
            System.out.println();
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            System.out.println();

            employee.get(index).increasePercentage(percentage);
        }

        System.out.println("List of employees:");

        employee.forEach(e -> System.out.println(e.getId() + ", " + e.getName() + ", " + e.getSalary()));

        sc.close();
    }
}
