package org.example.lab2.task7;

public final class IntegerCalculatorResult extends CalculatorResult {
    protected IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Integer a = (Integer) super.getRequest().leftOperand();
        Integer b = (Integer) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
