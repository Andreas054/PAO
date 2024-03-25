package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.UnknownOperandTypeException;

import java.util.ArrayList;
import java.util.List;

public final class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> calculatorRequestList = null;
        try {
            calculatorRequestList = InputConverter.mapRequests(args);

            List<CalculatorResult> calculatorResultList = new ArrayList<>();

            for (CalculatorRequest calculatorRequest : calculatorRequestList) {
                switch (calculatorRequest.getRequestType()) {
                    case "Boolean": calculatorResultList.add(new BooleanCalculatorResult(calculatorRequest)); break;
                    case "Integer": calculatorResultList.add(new IntegerCalculatorResult(calculatorRequest)); break;
                    case "Double": calculatorResultList.add(new DoubleCalculatorResult(calculatorRequest)); break;
                }
            }

            return calculatorResultList;
        } catch (UnknownOperandTypeException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
