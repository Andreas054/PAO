package org.example.lab4.calculator.exceptions;

public abstract class CalculatorRuntimeException extends RuntimeException {
    public CalculatorRuntimeException(String message) {
        super(message);
    }
}
