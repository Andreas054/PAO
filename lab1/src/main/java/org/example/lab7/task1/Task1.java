package org.example.lab7.task1;

import java.io.FileInputStream;

public class Task1 {
    public static void Metoda1() {
        StringBuilder succesString = new StringBuilder();
        boolean trecutDePrimaLinie = false;

        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/org/example/lab7/task1/task1input.txt")) {
            while (fileInputStream.available() > 0) {
                char toPrint = (char) fileInputStream.read();

                if (trecutDePrimaLinie) {
                    succesString.append(toPrint);
                }

                if (toPrint == '\n') {
                    trecutDePrimaLinie = true;
                }

//                System.out.print(toPrint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(succesString.toString());
    }


    public static void Metoda2() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/org/example/lab7/task1/task1input.txt")) {
            fileInputStream.skip("Do not print this.\n".length());

            while (fileInputStream.available() > 0) {
                char toPrint = (char) fileInputStream.read();
                System.out.print(toPrint);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
