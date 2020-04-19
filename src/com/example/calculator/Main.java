package com.example.calculator;

import java.math.BigDecimal;

import static com.example.calculator.Validator.isEmpty;
import static com.example.calculator.Validator.isValid;

public class Main {

    public static void main(String[] args) {
        if (!isEmpty(args)) {
            throw new RuntimeException("Expression can't be empty.");
        }
        String expression = args[0].trim().replace(" ", "");

        if (!isValid(expression)) {
            throw new RuntimeException("Not valid expression.");
        }

        Calculator calculator = new Calculator(new Parser());
        BigDecimal res = calculator.calculate(expression);
        System.out.println(res);
    }

}
