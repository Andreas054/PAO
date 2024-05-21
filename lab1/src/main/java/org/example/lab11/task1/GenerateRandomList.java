package org.example.lab11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomList {
    public static List<Integer> generateRandomList(int nrElemente, int maxInt) {
        Random random = new Random();

        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < nrElemente; i++) {
            randomIntegers.add(random.nextInt(maxInt));
        }

        return randomIntegers;
    }
}
