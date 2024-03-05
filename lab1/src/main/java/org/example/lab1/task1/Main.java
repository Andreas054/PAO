package org.example.lab1.task1;

import org.example.lab1.task2.Course;
import org.example.lab1.task2.Student;
import org.example.lab1.task2.StudentAllocator;
import org.example.lab1.task4.DummyCalculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student[] students = StudentAllocator.createStudents();

        Course course = new Course("PAO", 5, students);

        Student[] studentsPassed = course.showAllPassingStudents();

        System.out.println(course.chooseStudentRandomly());
        System.out.println(Arrays.toString(studentsPassed));

        System.out.println(course.isStudentPassing(400));
        System.out.println(course.isStudentPassing(2));

        System.out.println(course.isStudentPassing("JANJFNKF"));
        System.out.println(course.isStudentPassing("Marian"));

//        task 4
        DummyCalculator dummyCalculator = new DummyCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String inputStr = scanner.nextLine();
        while (!inputStr.equals("quit")) {
            dummyCalculator.calculate(inputStr.split(" "));

            System.out.print("Input: ");
            inputStr = scanner.nextLine();
        }
    }
}
