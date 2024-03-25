package org.example.lab4.task4_5;

public class Task4_5 {
    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }

        System.out.println("3");
    }

    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (ClassCastException classCastException) {
            System.out.println("NO FAIL)");
        } catch (RuntimeException e) {
            System.out.println("fail");
        }
    }
}
