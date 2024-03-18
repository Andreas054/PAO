package org.example.lab2.task7;

public final class DoubleCalculatorResult extends CalculatorResult {
    protected DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Double a = (Double) super.getRequest().leftOperand();
        Double b = (Double) super.getRequest().rightOperand();
        String operation = super.getRequest().operation();

        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
