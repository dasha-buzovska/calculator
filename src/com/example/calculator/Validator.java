package com.example.calculator;

public class Validator {

    public static boolean isEmpty(String[] args) {
        return args.length > 0 && !args[0].trim().equals("");
    }

    public static boolean isValid(String expression) {
        return expression.matches("[0-9+-]+");
    }

}
