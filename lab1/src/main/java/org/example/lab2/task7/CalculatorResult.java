package org.example.lab2.task7;

public abstract class CalculatorResult {
    private CalculatorRequest calculatorRequest;
    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest() {
        return this.calculatorRequest;
    }

    public abstract Object computeResult();
}
