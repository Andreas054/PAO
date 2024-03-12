package org.example.lab2.task7;

public class IntegerCalculatorResult extends CalculatorResult {
    protected IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Integer a = (Integer) super.getRequest().getLeftOperand();
        Integer b = (Integer) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
