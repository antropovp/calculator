package com.epam.izh.rd.online.service;

public class InputValidatorImpl implements InputValidator {

    public boolean validate(String input) {
        return (input != null) && doesBeginWithNumber(input) && hasOnlyNumbersAndOperators(input)
                && !hasDoubleOperators(input);
    }

    public boolean doesBeginWithNumber(String input) {
        return input.substring(0, 1).matches("\\d|\\.");
    }

    public boolean hasOnlyNumbersAndOperators(String input) {
        return input.matches("[\\d+\\-*/.]+");
    }

    public boolean hasDoubleOperators(String input) {

        String[] elements = input.split("\\b");

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].matches("[^\\d.]*")) {
                if (elements[i+1].matches("[^\\d.]*")) {
                    return true;
                }
            }
        }

        return false;
    }
}
