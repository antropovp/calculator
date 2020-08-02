package com.epam.izh.rd.online.service;

public interface InputValidator {

    boolean isCorrectInput(String input);

    boolean doesBeginWithNumber();
    boolean isOnlyNumbersAndOperators(String input);
    boolean isWrongOperation(String input);
    boolean isDoubleOperators(String input);
    boolean isNegativeNumbers(String input);
}
