package com.epam.izh.rd.online;

import com.epam.izh.rd.online.exception.DoesNotBeginWithNumber;
import com.epam.izh.rd.online.exception.DoesNotEndWithNumber;
import com.epam.izh.rd.online.exception.DoubleOperatorsException;
import com.epam.izh.rd.online.exception.InvalidCharacterException;
import com.epam.izh.rd.online.service.InputValidator;
import com.epam.izh.rd.online.service.InputValidatorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setup() {
        inputValidator = new InputValidatorImpl();
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testDoesBeginWithNumber")
    @DisplayName("Тест метода InputValidator.doesBeginWithNumber(String input)")
    void testDoesBeginWithNumber(String param, boolean expected) throws DoesNotBeginWithNumber {
        assertEquals(expected, inputValidator.doesBeginWithNumber(param), "Для входного параметра: " + param);
        assertThrows(DoesNotBeginWithNumber.class,
                () -> inputValidator.doesBeginWithNumber("+7+5"), "Error: Doesn't begin with a number.");
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testDoesEndWithNumber")
    @DisplayName("Тест метода InputValidator.doesEndWithNumber(String input)")
    void testDoesEndWithNumber(String param, boolean expected) throws DoesNotEndWithNumber {
        assertEquals(expected, inputValidator.doesEndWithNumber(param), "Для входного параметра: " + param);
        assertThrows(DoesNotEndWithNumber.class,
                () -> inputValidator.doesEndWithNumber("7+5+"), "Error: Doesn't end with a number.");
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testHasOnlyNumbersAndOperators")
    @DisplayName("Тест метода InputValidator.hasOnlyNumbersAndOperators(String input)")
    void testHasOnlyNumbersAndOperators(String param, boolean expected) throws InvalidCharacterException {
        assertEquals(expected, inputValidator.hasOnlyNumbersAndOperators(param), "Для входного параметра: " + param);
        assertThrows(InvalidCharacterException.class,
                () -> inputValidator.hasOnlyNumbersAndOperators("7+5/4-8*a"),
                "Error: Contains invalid characters.");
        assertThrows(InvalidCharacterException.class,
                () -> inputValidator.hasOnlyNumbersAndOperators("1?0"),
                "Error: Contains invalid characters.");
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testHasNoDoubleOperators")
    @DisplayName("Тест метода InputValidator.hasNoDoubleOperators(String input)")
    void testHasNoDoubleOperators(String param, boolean expected) throws DoubleOperatorsException {
        assertEquals(expected, inputValidator.hasNoDoubleOperators(param), "Для входного параметра: " + param);
        assertThrows(DoubleOperatorsException.class,
                () -> inputValidator.hasNoDoubleOperators("7++5"),
                "Error: Has more than one operator in a row.");
        assertThrows(DoubleOperatorsException.class,
                () -> inputValidator.hasNoDoubleOperators("7+5-4//2"),
                "Error: Has more than one operator in a row.");
    }

}
