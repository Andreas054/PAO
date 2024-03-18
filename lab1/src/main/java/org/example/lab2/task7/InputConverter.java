package org.example.lab2.task7;

import java.util.ArrayList;
import java.util.List;

public final class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> calculatorRequestList = new ArrayList<CalculatorRequest>();
        for (int i = 0; i < args.length / 3; i++) {
            String leftOperandString = args[i * 3].replace(",", "").replace("\"", "");
            String rightOperandString = args[i * 3 + 2].replace(",", "").replace("\"", "");
            String operation = args[i * 3 + 1].replace(",", "").replace("\"", "");

            Object leftOperand, rightOperand;

            if (leftOperandString.equals("true") | leftOperandString.equals("false")) {
                leftOperand = Boolean.parseBoolean(leftOperandString);
                rightOperand = Boolean.parseBoolean(rightOperandString);
            }
            else {
                try {
                    leftOperand = Integer.parseInt(leftOperandString);
                    rightOperand = Integer.parseInt(rightOperandString);
                } catch (Exception e) {
                    leftOperand = Double.parseDouble(leftOperandString);
                    rightOperand = Double.parseDouble(rightOperandString);
                }

            }

            calculatorRequestList.add(new CalculatorRequest(leftOperand, rightOperand, operation));
        }
        return calculatorRequestList;
    }
}
