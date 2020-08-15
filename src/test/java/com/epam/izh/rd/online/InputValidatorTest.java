package com.epam.izh.rd.online;

import com.epam.izh.rd.online.service.InputValidator;
import com.epam.izh.rd.online.service.InputValidatorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setup() {
        inputValidator = new InputValidatorImpl();
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testDoesBeginWithNumber")
    @DisplayName("Тест метода InputValidator.doesBeginWithNumber(String input)")
    void testDoesBeginWithNumber(String param, boolean expected) {
        assertEquals(expected, inputValidator.doesBeginWithNumber(param), "Для входного параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testDoesEndWithNumber")
    @DisplayName("Тест метода InputValidator.doesEndWithNumber(String input)")
    void testDoesEndWithNumber(String param, boolean expected) {
        assertEquals(expected, inputValidator.doesEndWithNumber(param), "Для входного параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testHasOnlyNumbersAndOperators")
    @DisplayName("Тест метода InputValidator.hasOnlyNumbersAndOperators(String input)")
    void testHasOnlyNumbersAndOperators(String param, boolean expected) {
        assertEquals(expected, inputValidator.hasOnlyNumbersAndOperators(param), "Для входного параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testHasNoDoubleOperators")
    @DisplayName("Тест метода InputValidator.hasNoDoubleOperators(String input)")
    void testHasNoDoubleOperators(String param, boolean expected) {
        assertEquals(expected, inputValidator.hasNoDoubleOperators(param), "Для входного параметра: " + param);
    }

}
