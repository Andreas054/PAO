package org.example.lab8.calculator;

import org.example.lab4.calculator.BooleanCalculatorResult;
import org.example.lab4.calculator.CalculatorRequest;
import org.example.lab4.calculator.exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BooleanCalculatorTest {
    private BooleanCalculatorResult booleanCalculatorResult;

    @ParameterizedTest
    @MethodSource("testAndData")
    void testAnd(CalculatorRequest calculatorRequest, boolean expected) {
        booleanCalculatorResult = new BooleanCalculatorResult(calculatorRequest);

        try {
            assertEquals(expected, booleanCalculatorResult.computeResult(), "Results should be equal");
        } catch (InvalidOperationException e) {
            fail("Unexpected InvalidOperationException");
        }
    }

    private static Stream<Arguments> testAndData() {
        return Stream.of(
                Arguments.of(new CalculatorRequest(true, true, "&"), true),
                Arguments.of(new CalculatorRequest(true, false, "&"), false),
                Arguments.of(new CalculatorRequest(false, true, "&"), false),
                Arguments.of(new CalculatorRequest(false, false, "&"), false),
                Arguments.of(new CalculatorRequest(true, true, "|"), true),
                Arguments.of(new CalculatorRequest(true, false, "|"), true),
                Arguments.of(new CalculatorRequest(false, true, "|"), true),
                Arguments.of(new CalculatorRequest(false, false, "|"), false)
        );
    }

    @Test
    public void testInvalidOperation() {
        CalculatorRequest calculatorRequest = new CalculatorRequest(true, false, "+");
        booleanCalculatorResult = new BooleanCalculatorResult(calculatorRequest);

        assertThrows(InvalidOperationException.class, () -> booleanCalculatorResult.computeResult());
    }
}