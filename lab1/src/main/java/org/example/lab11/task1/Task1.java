package org.example.lab11.task1;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task1 {
    public static void t0normal(List<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.println(integer + "^2=" + integer * integer);
        }
    }

    public static void t1thread(List<Integer> integerList) {
//        System.out.println(Runtime.getRuntime().availableProcessors());

        int nrThreads = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < nrThreads; i++) {
            List<Integer> subList = integerList.subList(i * integerList.size() / nrThreads, (i + 1) * integerList.size() / nrThreads);
            new Thread(() -> {
                for (Integer integer : subList) {
                    System.out.println(integer + "^2=" + integer * integer);
                }
            }).start();
        }
    }

    public static void t2parallelStream(List<Integer> integerList) {
        integerList.parallelStream().forEach(integer ->
                System.out.println(integer + "^2=" + integer * integer));
    }

    public static List<Future<Map<Integer, Integer>>> t3Future(List<Integer> integerList) {
        int nrThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nrThreads);

        List<Future<Map<Integer, Integer>>> futures = new ArrayList<>();
        for (Integer integer : integerList) {
            Map<Integer, Integer> map = new HashMap<>();
            Future<Map<Integer, Integer>> future = executor.submit(() -> {
                map.put(integer, integer * integer);
                return map;
            });
            futures.add(future);
        }

        executor.shutdown();

        return futures;
    }
}
