package org.example.lab8.task4;

import org.example.lab4.calculator.CalculatorRequest;

import java.sql.*;

public class Task4 {
    public static void removeDuplicates() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laborator", "student", "student")) {
            String createTemp = "CREATE TEMPORARY TABLE IF NOT EXISTS tempSmarterCalculatorResults AS " +
                    "(SELECT MIN(id) as id FROM smarterCalculatorResults WHERE " +
                    "CONCAT(operation_type, left_operand, right_operand, operation) IN " +
                    "   (SELECT DISTINCT CONCAT(operation_type, left_operand, right_operand, operation)" +
                    "   FROM smarterCalculatorResults) GROUP BY CONCAT(operation_type, left_operand, right_operand, operation))";

            String deleteSql = "DELETE FROM smarterCalculatorResults WHERE id NOT IN (SELECT id FROM tempSmarterCalculatorResults)";

            try (java.sql.Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTemp);
                statement.executeUpdate(deleteSql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}