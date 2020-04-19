package com.example.calculator;

import com.example.calculator.operation.BinaryOperation;
import com.example.calculator.operation.Entry;
import com.example.calculator.operation.OperationNumber;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    private Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public BigDecimal calculate(String source) {
        List<Entry> binaryOperations = parser.parse(source);
        return execute(binaryOperations);
    }

    private BigDecimal execute(List<Entry> entries) {
        if (entries.size() == 1) {
            if (entries.get(0) instanceof OperationNumber) {
                return ((OperationNumber) entries.get(0)).getValue();
            } else {
                throw new RuntimeException("Not valid expression. Something went wrong.");
            }
        }
        int lastOperationIndex = getLastOperationIndex(entries);
        List<Entry> left = entries.subList(0, lastOperationIndex);
        List<Entry> right = entries.subList(lastOperationIndex + 1, entries.size());
        BinaryOperation operation;
        if (entries.get(lastOperationIndex) instanceof BinaryOperation) {
            operation = (BinaryOperation) entries.get(lastOperationIndex);
        } else {
            throw new RuntimeException("Not valid expression. Something went wrong.");
        }
        return operation.process(execute(left), execute(right));
    }

    private static int getLastOperationIndex(List<Entry> entries) {
        return entries.size() - 2;
    }

}
