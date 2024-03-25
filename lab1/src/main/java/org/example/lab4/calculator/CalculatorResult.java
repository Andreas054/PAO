package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.InvalidOperationException;

public abstract class CalculatorResult {
    private final CalculatorRequest calculatorRequest;
    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest() {
        return this.calculatorRequest;
    }

    public abstract Object computeResult() throws InvalidOperationException;
}
