package app;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String file = sc.nextLine();

        try(BufferedReader bf = new BufferedReader(new FileReader(file))) {

            List<Employee> employees = new ArrayList<>();
            String line = bf.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = bf.readLine();
            }

            System.out.print("Enter Salary: ");
            double comparisonSalary = sc.nextDouble();

            System.out.println("Email of people whose salary is more than " + comparisonSalary);

           List<String> emails = employees.stream()
                    .filter(employee -> employee.getSalary()> comparisonSalary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();

           emails.forEach(System.out::println);

           double sum = employees.stream()
                   .filter(employee -> employee.getName().charAt(0) == 'M')
                   .map(Employee::getSalary)
                   .reduce(0.0, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': R$" + String.format("%,.2f", sum));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



// Path of file: /home/kayke/Documentos/employees.txt