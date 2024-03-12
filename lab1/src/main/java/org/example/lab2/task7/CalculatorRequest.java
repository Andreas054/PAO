package org.example.lab2.task7;

public class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;
    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }
    public Object getLeftOperand() {
        return leftOperand;
    }
    public Object getRightOperand() {
        return rightOperand;
    }
    public String getOperation() {
        return operation;
    }
    public String getRequestType() {
        if (leftOperand instanceof Boolean) {
            return "Boolean";
        } else if (leftOperand instanceof Integer) {
            return "Integer";
        } else {
            return "Double";
        }
    }
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }
}
