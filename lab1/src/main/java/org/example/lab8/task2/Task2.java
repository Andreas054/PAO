package org.example.lab8.task2;

import org.example.lab4.calculator.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static ResultSet selectAllFromCalculator() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laborator", "student", "student")) {
            String selectSql = "SELECT\n" +
                    "  operation_type,\n" +
                    "  left_operand,\n" +
                    "  right_operand,\n" +
                    "  operation,\n" +
                    "  result\n" +
                    "FROM smarterCalculatorResults;";

            try (Statement statement = connection.createStatement()) {
                return statement.executeQuery(selectSql);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Task2() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laborator", "student", "student")) {
            String selectSql = "SELECT\n" +
                    "  operation_type,\n" +
                    "  left_operand,\n" +
                    "  right_operand,\n" +
                    "  operation,\n" +
                    "  result\n" +
                    "FROM smarterCalculatorResults;";

            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        CalculatorRequest request = new CalculatorRequest(
                                resultSet.getString("left_operand"),
                                resultSet.getString("right_operand"),
                                resultSet.getString("operation")
                        );
                        System.out.println("Operation Type: " + resultSet.getString("operation_type") +
                                "\t/\t" + request + " = " + resultSet.getString("result"));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
