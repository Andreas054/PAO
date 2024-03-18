package org.example.lab2;

import org.example.lab1.task4.DummyCalculator;
import org.example.lab2.task6.Dreptunghi;
import org.example.lab2.task6.Paralelogram;
import org.example.lab2.task6.Patrat;
import org.example.lab2.task6.Romb;
import org.example.lab2.task7.CalculatorRequest;
import org.example.lab2.task7.CalculatorResult;
import org.example.lab2.task7.SmarterCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainLab2 {
    public static void main(String[] args) {
        Paralelogram paralelogram = new Paralelogram(1, 2, 35, 55 );
        Romb romb = new Romb(1, 3, 30, 60, 2, 3);
        Dreptunghi dreptunghi = new Dreptunghi(5, 4);
        Patrat patrat = new Patrat(3);

//        task 6
        System.out.println(paralelogram.arie());
        System.out.println(romb.arie());
        System.out.println(dreptunghi.arie());
        System.out.println(patrat.arie());

//        task 7
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
//        "1", "+", "2", "2", "*", "5", "1", "+", "5.0", "1.0", "-", "2", "10.0", "/", "1", "true", "&", "true", "true", "&", "false", "true", "|", "false", "false", "|", "false",
        String inputStr = scanner.nextLine();

//        for (String a : inputStr.split(" ")) {
//            System.out.println(a.replace(",", "").replace("\"", ""));
//        }

        foo(inputStr.split(" "));
    }

    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults =  SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}
