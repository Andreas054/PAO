package org.example.lab4;

import org.example.lab4.calculator.CalculatorRequest;
import org.example.lab4.calculator.CalculatorResult;
import org.example.lab4.calculator.SmarterCalculator;
import org.example.lab4.calculator.exceptions.CalculatorRuntimeException;
import org.example.lab4.calculator.exceptions.InvalidOperationException;
import org.example.lab4.task1.JustMyFirstException;
import org.example.lab4.task3.Student;
import org.example.lab4.task4_5.Task4_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainLab4 {
    public static void main(String[] args) {

//        TASK 1
        try {
            throw new JustMyFirstException();
        }
        catch (JustMyFirstException justMyFirstException)
        {
            System.out.println(justMyFirstException.getMessage());
        }


//        TASK 3
        Map<String, Double> courseInfo = new HashMap<String, Double>() {{
            put("MDS", 5.5);
            put("AA", 9.5);
            put("IA", 10.0);
        }};
        Student student1 = new Student("Marian", courseInfo);
        try {
            Student student2 = student1.clone();
//            student2.courseInformation.put("MDS", 50.0);

            System.out.println(student1);
            System.out.println(student2);
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.err.println(cloneNotSupportedException.getMessage());
        }


//        TASK 4 & 5
        Task4_5.foo();
        Task4_5.bar();


//        TASK 6
        







// calculator
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
//        "1", "+", "2", "2", "*", "5", "1", "+", "5.0", "1.0", "-", "2", "10.0", "/", "1", "true", "&", "true", "true", "&", "false", "true", "|", "false", "false", "|", "false",

//        "test", "*", "test2",
//        "true", "+", "true",

//        "5.0", "/", "0.0",
//        "5.0", "&", "3.0",

//        "2", "/", "0",
//        "1", "&", "7",



        String inputStr = scanner.nextLine();

//        for (String a : inputStr.split(" ")) {
//            System.out.println(a.replace(",", "").replace("\"", ""));
//        }

        try {
            foo(inputStr.split(" "));
        } catch (CalculatorRuntimeException calculatorRuntimeException)
        {
            System.err.println(calculatorRuntimeException.getMessage());
        }
    }

    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);
        if (calculationResults != null) {
            for (CalculatorResult result : calculationResults) {
                CalculatorRequest request = result.getRequest();
                try {
                    System.out.println("Operation " + request + " has result " + result.computeResult());
                } catch (InvalidOperationException invalidOperationException)
                {
                    System.err.println(invalidOperationException.getMessage());
                }
            }
        }
    }
}
