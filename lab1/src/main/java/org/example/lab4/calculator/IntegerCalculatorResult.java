package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.InvalidOperationException;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        Integer a = (Integer) super.getRequest().leftOperand();
        Integer b = (Integer) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0)
                {
                    throw new InvalidOperationException("Divide by 0 for Integer!");
                }
                return a / b;
            default: throw new InvalidOperationException("Invalid operation for Integer \"" + operation + "\"");
        }
    }
}
