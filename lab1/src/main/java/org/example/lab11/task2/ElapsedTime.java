package org.example.lab11.task2;

import org.example.lab11.task1.FutureCalculate;
import org.example.lab11.task1.GenerateRandomList;
import org.example.lab11.task1.Task1;

import java.util.List;

public class ElapsedTime {
    public static long elapsedTime(int select, int nrElemente, int maxInt) {
        long start = System.currentTimeMillis();

        List<Integer> randomIntegers = GenerateRandomList.generateRandomList(nrElemente, maxInt);

        switch (select) {
            case 0: Task1.t0normal(randomIntegers); break;
            case 1: Task1.t1thread(randomIntegers); break;
            case 2: Task1.t2parallelStream(randomIntegers); break;
            case 3: FutureCalculate.FutureCalculate(randomIntegers); break;
        }

        long finish = System.currentTimeMillis();

        return finish - start;
    }
}
