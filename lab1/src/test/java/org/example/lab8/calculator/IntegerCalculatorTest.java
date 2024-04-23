package org.example.lab8.calculator;

import org.example.lab4.calculator.CalculatorRequest;
import org.example.lab4.calculator.IntegerCalculatorResult;
import org.example.lab4.calculator.exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerCalculatorTest {
    private IntegerCalculatorResult integerCalculatorResult;

    @ParameterizedTest
    @MethodSource("testIntegerData")
    void testInteger(CalculatorRequest calculatorRequest, int expected) {
        integerCalculatorResult = new IntegerCalculatorResult(calculatorRequest);

        try {
            assertEquals(expected, integerCalculatorResult.computeResult(), "Results should be equal");
        } catch (InvalidOperationException e) {
            fail("Unexpected InvalidOperationException");
        }
    }

    private static Stream<Arguments> testIntegerData() {
        return Stream.of(
                Arguments.of(new CalculatorRequest(5, 7, "+"), 12),
                Arguments.of(new CalculatorRequest(9, 3, "*"), 27),
                Arguments.of(new CalculatorRequest(16, 4, "/"), 4),
                Arguments.of(new CalculatorRequest(98, 114, "-"), -16)
        );
    }

    @Test
    public void testInvalidOperation() {
        CalculatorRequest calculatorRequest = new CalculatorRequest(1, 1, "&");
        integerCalculatorResult = new IntegerCalculatorResult(calculatorRequest);

        assertThrows(InvalidOperationException.class, () -> integerCalculatorResult.computeResult());
    }
}
