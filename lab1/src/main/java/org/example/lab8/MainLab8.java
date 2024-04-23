package org.example.lab8;

import org.example.lab8.task1.Task1;
import org.example.lab8.task2.Task2;
import org.example.lab8.task3.Task3;
import org.example.lab8.task4.Task4;

public class MainLab8 {
//    docker start ...
//    mysql -h 127.0.0.1 -P 3306 -u student --password=student
    public static void main(String[] args) {
        String inputStr = "\"1\", \"+\", \"2\", \"2\", \"*\", \"5\", \"1\", \"+\", \"5.0\", \"1.0\", \"-\", \"2\", \"10.0\", \"/\", \"1\", \"true\", \"&\", \"true\", \"true\", \"&\", \"false\", \"true\", \"|\", \"false\", \"false\", \"|\", \"false\",";
        Task1.Task1(inputStr.split(" "));

        Task2.Task2();

        Task3.deleteByOperationType("Boolean");

        Task4.removeDuplicates();
    }
}
