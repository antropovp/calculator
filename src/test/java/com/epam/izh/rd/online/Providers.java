package com.epam.izh.rd.online;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    private Providers() {

    }

    // InputValidatorTest

    public static Stream<Arguments> testDoesBeginWithNumber() {
        return Stream.of(
                arguments("7+5", true),
                arguments("+7+5", false),
                arguments(".7+5", true)
        );
    }

    public static Stream<Arguments> testDoesEndWithNumber() {
        return Stream.of(
                arguments("7+5", true),
                arguments("7+5+", false),
                arguments("7+5.", true)
        );
    }

    public static Stream<Arguments> testHasOnlyNumbersAndOperators() {
        return Stream.of(
                arguments("7+5/4-8*1", true),
                arguments("7+5/4-8*a", false),
                arguments("1?0", false)
        );
    }

    public static Stream<Arguments> testHasNoDoubleOperators() {
        return Stream.of(
                arguments("7+5", true),
                arguments("7++5", false),
                arguments("7+5-4//2", false)
        );
    }

}
