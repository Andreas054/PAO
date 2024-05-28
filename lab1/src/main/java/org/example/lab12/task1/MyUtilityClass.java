package org.example.lab12.task1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.BiFunction;

public class MyUtilityClass {
    public static void printCollection(Collection<?> collection) {
        if (!collection.isEmpty()) {
            System.out.print("[");
            for (Object o : collection) {
                System.out.print(o + ", ");
            }
            System.out.println("\b\b]");
        }
    }

    public static <T, U> U aggregate(Collection<T> collection, U defaultVal, BiFunction<U, T, U> accumulator) {
        U suma = defaultVal;
        for (T item : collection) {
            suma = accumulator.apply(suma, item);
        }
        return suma;
    }

    public static <T> Collection<T> duplicateCollection(Collection<T> collection) {
        Collection<T> duplicate = new LinkedList<>();
        for (T item : collection) {
            duplicate.add(item);
            duplicate.add(item);
        }
        return duplicate;
    }
}
