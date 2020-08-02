package com.epam.izh.rd.online.service;

public interface InputValidator {

    boolean validate(String input);

    boolean doesBeginWithNumber(String input);
    boolean hasOnlyNumbersAndOperators(String input);
    boolean hasDoubleOperators(String input);
}
