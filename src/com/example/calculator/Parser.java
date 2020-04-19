package com.example.calculator;

import com.example.calculator.operation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Entry> parse(String expression) {
        List<Entry> result = new ArrayList<>();
        int startPosition = 0;

        for (int i = 1; i < expression.length(); i++) {
            int j = getNumberEndPosition(i, expression);
            BigDecimal number = new BigDecimal(expression.substring(startPosition, j));
            result.add(new OperationNumber(number));
            i = j;

            if (i < expression.length()) {
                char operation = expression.charAt(i);
                result.add(getOperation(operation));
            }

            startPosition = i+1;
        }
        return result;
    }

    private int getNumberEndPosition(int position, String expression) {
        while (position < expression.length() && isNumber(expression.charAt(position))) {
            position++;
        }
        return position;
    }

    private boolean isNumber(char element) {
        return element >= '0' && element <= '9';
    }

    private BinaryOperation getOperation(char operation) {
        if (operation == '+') {
            return new Addition();
        } else if (operation == '-') {
            return new Subtraction();
        }
        return null;
    }

}
