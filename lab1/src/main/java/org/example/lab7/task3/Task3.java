package org.example.lab7.task3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Task3 {
    public static void Task3() {
        for (Integer i = 1; i <= 10; i++) {
            try (FileWriter fileWriter = new FileWriter("src/main/java/org/example/lab7/task3/outputFolder/fisier_" + i + ".txt")) {
                fileWriter.write(i.toString());
                fileWriter.write(" ");
                fileWriter.write(LocalDateTime.now().toString());
                fileWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
