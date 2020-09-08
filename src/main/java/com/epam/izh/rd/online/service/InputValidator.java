package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.exception.DoesNotBeginWithNumber;
import com.epam.izh.rd.online.exception.DoesNotEndWithNumber;
import com.epam.izh.rd.online.exception.DoubleOperatorsException;
import com.epam.izh.rd.online.exception.InvalidCharacterException;

public interface InputValidator {

    boolean validate(String input) throws Exception;

    boolean doesBeginWithNumber(String input) throws DoesNotBeginWithNumber;
    boolean doesEndWithNumber(String input) throws DoesNotEndWithNumber;
    boolean hasOnlyNumbersAndOperators(String input) throws InvalidCharacterException;
    boolean hasNoDoubleOperators(String input) throws DoubleOperatorsException;
}
