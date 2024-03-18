package org.example.lab2.task7;

public final class BooleanCalculatorResult extends CalculatorResult {
    protected BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Boolean a = (Boolean) super.getRequest().leftOperand();
        Boolean b = (Boolean) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        if (operation.equals("&")) {
            return a & b;
        }
        return a | b;
    }
}
