package org.example.lab2.task7;

public class BooleanCalculatorResult extends CalculatorResult {
    protected BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Boolean a = (Boolean) super.getRequest().getLeftOperand();
        Boolean b = (Boolean) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        if (operation.equals("&")) {
            return a & b;
        }
        return a | b;
    }
}
