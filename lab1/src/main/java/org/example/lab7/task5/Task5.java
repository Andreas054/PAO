package org.example.lab7.task5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Task5 {
    public static List<Double> citesteFisier() {
        List<Double> integerList = new LinkedList<>();
        StringBuilder lineString = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/org/example/lab7/task5/task5input.txt")) {
            while (fileInputStream.available() > 0) {
                char toPrint = (char) fileInputStream.read();

                if (toPrint == '\n') {
                    try {
                        integerList.add(Double.parseDouble(lineString.toString()));
                    } catch (NumberFormatException e) {
                        System.out.println("Nu este numar: " + lineString.toString());
                    }
                    lineString.delete(0, lineString.length());
                } else {
                    lineString.append(toPrint);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return integerList;
    }

    public static void Task5() {
        List<Double> doubleList = citesteFisier();
        doubleList = doubleList.subList(1, doubleList.size());

        List<Function<Double, Double>> consumerList = new ArrayList<>();
        consumerList.add(x -> x * 5);
        consumerList.add(x -> x + 1);
        consumerList.add(x -> 1 / x);
        consumerList.add(x -> x * x);
        consumerList.add(x -> Math.sin(x));

        Random rand = new Random();

        doubleList.stream()
                .map(x -> consumerList.get(rand.nextInt(consumerList.size())).apply(x))
                .forEach(System.out::println);
    }
}
