package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.exception.*;

public class InputValidatorImpl implements InputValidator {

    public boolean validate(String input) throws Exception {

        if (input == null) {
            throw new NullInputException("Error: Empty input.");
        }

        return doesBeginWithNumber(input) && doesEndWithNumber(input) && hasOnlyNumbersAndOperators(input)
                && hasNoDoubleOperators(input);
    }

    public boolean doesBeginWithNumber(String input) throws DoesNotBeginWithNumber {

        if (input.substring(0, 1).matches("\\d|\\.")) {
            return true;
        } else {
            throw new DoesNotBeginWithNumber("Error: Doesn't begin with a number.");
        }
    }

    public boolean doesEndWithNumber(String input) throws DoesNotEndWithNumber {

        if (input.substring(input.length() - 1).matches("\\d|\\.")) {
            return true;
        } else {
            throw new DoesNotEndWithNumber("Error: Doesn't end with a number.");
        }
    }

    public boolean hasOnlyNumbersAndOperators(String input) throws InvalidCharacterException {

        if (input.matches("[\\d+\\-*/.]+")) {
            return true;
        } else {
            throw new InvalidCharacterException("Error: Contains invalid characters.");
        }
    }

    public boolean hasNoDoubleOperators(String input) throws DoubleOperatorsException {

        String[] elements = input.split("\\b");

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].matches("[^\\d.]*")) {
                if ((elements[i].length() > 1) || (elements[i+1].matches("[^\\d.]*"))) {
                    throw new DoubleOperatorsException("Error: Has more than one operator in a row.");
                }
            }
        }

        return true;
    }
}
