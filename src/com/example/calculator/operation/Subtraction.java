package com.example.calculator.operation;

import java.math.BigDecimal;

public class Subtraction implements BinaryOperation {

    @Override
    public BigDecimal process(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

}
