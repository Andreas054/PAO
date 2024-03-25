package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.InvalidOperationException;

public final class BooleanCalculatorResult extends CalculatorResult {
    protected BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        Boolean a = (Boolean) super.getRequest().leftOperand();
        Boolean b = (Boolean) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        if (operation.equals("&")) {
            return a & b;
        } else if (operation.equals("|")) {
            return a | b;
        } else
        {
            throw new InvalidOperationException("Invalid operation for Boolean \"" + operation + "\"");
        }
    }
}
