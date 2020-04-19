package com.example.calculator.operation;

import java.math.BigDecimal;

public class OperationNumber implements Entry {

    private BigDecimal number;

    public OperationNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getValue() {
        return number;
    }
}
