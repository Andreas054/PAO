package org.example.lab2.task7;

public class DoubleCalculatorResult extends CalculatorResult {
    protected DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Double a = (Double) super.getRequest().getLeftOperand();
        Double b = (Double) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
