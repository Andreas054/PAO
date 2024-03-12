package org.example.lab2.task7;

import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> calculatorRequestList = InputConverter.mapRequests(args);
        List<CalculatorResult> calculatorResultList = new ArrayList<>();

        for (CalculatorRequest calculatorRequest : calculatorRequestList) {
            switch (calculatorRequest.getRequestType()) {
                case "Boolean": calculatorResultList.add(new BooleanCalculatorResult(calculatorRequest)); break;
                case "Integer": calculatorResultList.add(new IntegerCalculatorResult(calculatorRequest)); break;
                case "Double": calculatorResultList.add(new DoubleCalculatorResult(calculatorRequest)); break;
            }
        }

        return calculatorResultList;
    }
}
