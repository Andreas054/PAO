package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.InvalidOperationException;

public final class DoubleCalculatorResult extends CalculatorResult {
    protected DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        Double a = (Double) super.getRequest().leftOperand();
        Double b = (Double) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0)
                {
                    throw new InvalidOperationException("Divide by 0 for Double!");
                }
                return a / b;
            default: throw new InvalidOperationException("Invalid operation for Double \"" + operation + "\"");
        }
    }
}
