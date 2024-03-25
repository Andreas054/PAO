package org.example.lab4.calculator;

import org.example.lab4.calculator.exceptions.InvalidArgumentsLengthException;
import org.example.lab4.calculator.exceptions.UnknownOperandTypeException;

import java.util.ArrayList;
import java.util.List;

public final class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) throws UnknownOperandTypeException {
        if (args.length < 3)
        {
            throw new InvalidArgumentsLengthException("Sunt necesare minim 3 argumente!"); // ????
        }
        if (args.length % 3 != 0)
        {
            throw new InvalidArgumentsLengthException("Sunt necesare cate 3 argumente pentru fiecare \"operatie\"");
        }
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
                    try {
                        leftOperand = Double.parseDouble(leftOperandString);
                        rightOperand = Double.parseDouble(rightOperandString);
                    }
                    catch (Exception exception)
                    {
                        throw new UnknownOperandTypeException(leftOperandString + operation + rightOperandString);
                    }
                }

            }

            calculatorRequestList.add(new CalculatorRequest(leftOperand, rightOperand, operation));
        }
        return calculatorRequestList;
    }
}
