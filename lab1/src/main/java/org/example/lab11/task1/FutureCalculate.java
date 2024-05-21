package org.example.lab11.task1;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureCalculate {
    public static void FutureCalculate(List<Integer> randomIntegers) {
        List<Future<Map<Integer, Integer>>> futures = Task1.t3Future(randomIntegers);
        for (Future<Map<Integer, Integer>> future : futures) {
            try {
                Map<Integer, Integer> map = future.get();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + "^2=" + entry.getValue());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
