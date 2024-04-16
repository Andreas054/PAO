package org.example.lab7.task4;

import java.util.stream.IntStream;

public class Task4 {
    public static void Task4(int n) {
        IntStream.rangeClosed(0, n)
                .filter(x -> x % 2 == 0)
                .mapToObj(x -> new NumarPatrat(x))
                .forEach(System.out::println);

//        System.out.println(Arrays.toString(stream.toArray()));
    }
}
