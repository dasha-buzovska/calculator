package com.example.calculator.operation;

import java.math.BigDecimal;

public class Addition implements BinaryOperation {

    @Override
    public BigDecimal process(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

}
