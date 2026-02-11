package app;

import entities.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Student> set = new HashSet<>();
        String text = "How many students for course ";

        String[] courses = {"A", "B", "C"};
        for (String letter : courses) {
            System.out.print(text + letter + "?");
            int quantityOfStudents = sc.nextInt();
            for (int i = 1; i <= quantityOfStudents; i++) {
                int code = sc.nextInt();
                set.add(new Student(code));
            }
        }

        System.out.println("Total students: " + set.size());

    }
}