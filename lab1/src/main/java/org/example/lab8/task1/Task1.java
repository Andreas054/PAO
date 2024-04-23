package org.example.lab8.task1;

import org.example.lab4.calculator.CalculatorRequest;
import org.example.lab4.calculator.CalculatorResult;
import org.example.lab4.calculator.SmarterCalculator;
import org.example.lab4.calculator.exceptions.InvalidOperationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static Map<CalculatorRequest, CalculatorResult> callSmarterCalculator(String[] args) {
        Map<CalculatorRequest, CalculatorResult> calculatorReqResMap = new HashMap<>();

        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);
        if (calculationResults != null) {
            for (CalculatorResult result : calculationResults) {
                CalculatorRequest request = result.getRequest();

                calculatorReqResMap.putIfAbsent(request, result);
            }
        }

        return calculatorReqResMap;
    }

    public static void Task1(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laborator", "student", "student")) {
            try (Statement statement = connection.createStatement()) {
                String createTable = """
                  CREATE TABLE IF NOT EXISTS smarterCalculatorResults (
                      id INT auto_increment,
                      operation_type VARCHAR(20) NOT NULL,
                      left_operand VARCHAR(254) NOT NULL,
                      right_operand VARCHAR(254) NOT NULL,
                      operation VARCHAR(2) NOT NULL,
                      result VARCHAR(255) NOT NULL,
                      PRIMARY KEY (id)
                  );
                """;

                statement.execute(createTable);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Map<CalculatorRequest, CalculatorResult> calculatorReqResMap = callSmarterCalculator(args);

            for (Map.Entry<CalculatorRequest, CalculatorResult> entry : calculatorReqResMap.entrySet()) {
                try (Statement statement = connection.createStatement()) {
                    String insertCalculator = """
                      INSERT INTO smarterCalculatorResults (operation_type, left_operand, right_operand, operation, result)
                      VALUES ('%s', '%s', '%s', '%s', '%s');
                    """.formatted(
                            entry.getKey().getRequestType(),
                            entry.getKey().leftOperand(),
                            entry.getKey().rightOperand(),
                            entry.getKey().operation(),
                            entry.getValue().computeResult()
                    );

                    statement.execute(insertCalculator);
                } catch (SQLException | InvalidOperationException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
