package org.example.lab8.calculator;

import org.example.lab4.calculator.CalculatorRequest;
import org.example.lab4.calculator.DoubleCalculatorResult;
import org.example.lab4.calculator.exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {
    private DoubleCalculatorResult doubleCalculatorResult;

    @ParameterizedTest
    @MethodSource("testDoubleData")
    void testDouble(CalculatorRequest calculatorRequest, double expected) {
        doubleCalculatorResult = new DoubleCalculatorResult(calculatorRequest);

        try {
            assertEquals(expected, doubleCalculatorResult.computeResult(), "Results should be equal");
        } catch (InvalidOperationException e) {
            fail("Unexpected InvalidOperationException");
        }
    }

    private static Stream<Arguments> testDoubleData() {
        return Stream.of(
                Arguments.of(new CalculatorRequest(19.2, 3.8, "+"), 23.0),
                Arguments.of(new CalculatorRequest(0.5, 16.0, "*"), 8.0),
                Arguments.of(new CalculatorRequest(39.4, 2.0, "/"), 19.7),
                Arguments.of(new CalculatorRequest(200.1, 0.1, "-"), 200)
        );
    }

    @Test
    public void testInvalidOperation() {
        CalculatorRequest calculatorRequest = new CalculatorRequest(1.0, 1.9, "|");
        doubleCalculatorResult = new DoubleCalculatorResult(calculatorRequest);

        assertThrows(InvalidOperationException.class, () -> doubleCalculatorResult.computeResult());
    }
}
