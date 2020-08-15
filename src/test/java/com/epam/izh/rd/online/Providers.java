package com.epam.izh.rd.online;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
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

    // ParsingServiceTest

    public static Stream<Arguments> testParseReversePolish() {

        List<String> result1 = new ArrayList<>();
        result1.add("7");
        result1.add("+");
        result1.add("5");

        List<String> result2 = new ArrayList<>();
        result2.add("7");
        result2.add("+");
        result2.add("1.2");
        result2.add("/");
        result2.add("4");
        result2.add("-");
        result2.add("85");

        return Stream.of(
                arguments("7+5", result1),
                arguments("7+1.2/4-85", result2)
        );
    }

}
