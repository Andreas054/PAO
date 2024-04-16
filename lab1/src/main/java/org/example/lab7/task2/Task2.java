package org.example.lab7.task2;

import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void Metoda1() {
        StringBuilder succesString = new StringBuilder();
        boolean trecutDePrimaLinie = false;

        try (FileReader fileReader = new FileReader("src/main/java/org/example/lab7/task1/task1input.txt")) {
            int currentCharInt = fileReader.read();
            while (currentCharInt > 0) {

                char currentChar = (char) currentCharInt;

                if (trecutDePrimaLinie) {
                    succesString.append(currentChar);
                }

                if (currentChar == '\n') {
                    trecutDePrimaLinie = true;
                }

                currentCharInt = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(succesString.toString());
    }



    public static void Metoda2() {
        try (FileReader fileReader = new FileReader("src/main/java/org/example/lab7/task1/task1input.txt")) {
            fileReader.skip("Do not print this.\n".length());
            int currentCharInt = fileReader.read();
            while (currentCharInt > 0) {
                char currentChar = (char) currentCharInt;

                System.out.print(currentChar);

                currentCharInt = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
