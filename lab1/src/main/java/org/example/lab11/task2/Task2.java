package org.example.lab11.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Task2 {
    public static void Task2() {
        try (FileWriter fileWriter = new FileWriter("src/main/java/org/example/lab11/task2/outputTime.txt")) {
                List<Integer> parameters = List.of(10, 1000, 10000, 10000000);
            for (Integer parameter : parameters) {
                long timeNormal = ElapsedTime.elapsedTime(0, parameter, 1000);
                long timeThreads = ElapsedTime.elapsedTime(1, parameter, 1000);
                long timeParallelStream = ElapsedTime.elapsedTime(2, parameter, 1000);
                long timeFuture = ElapsedTime.elapsedTime(3, parameter, 1000);

                fileWriter.write(parameter + " elemente:");
                fileWriter.write("\nNormal\t\t" + timeNormal);
                fileWriter.write("\nThreads\t\t" + timeThreads);
                fileWriter.write("\nParallel\t" + timeParallelStream);
                fileWriter.write("\nFuture\t\t" + timeFuture);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
