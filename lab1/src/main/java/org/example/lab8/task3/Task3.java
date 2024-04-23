package org.example.lab8.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task3 {
    public static void deleteByOperationType(String operationType) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laborator", "student", "student")) {
            String deleteSql = "DELETE FROM smarterCalculatorResults WHERE operation_type = '%s';".formatted(operationType);

            try (java.sql.Statement statement = connection.createStatement()) {
                statement.executeUpdate(deleteSql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
