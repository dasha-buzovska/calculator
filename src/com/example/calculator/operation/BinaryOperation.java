package com.example.calculator.operation;

import java.math.BigDecimal;

public interface BinaryOperation extends Entry {

    BigDecimal process(BigDecimal left, BigDecimal right);

}
