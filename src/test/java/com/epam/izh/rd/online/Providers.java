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
        result1.add("5");
        result1.add("+");

        List<String> result2 = new ArrayList<>();
        result2.add("7");
        result2.add("1.2");
        result2.add("4");
        result2.add("/");
        result2.add("+");
        result2.add("85");
        result2.add("-");

        return Stream.of(
                arguments("7+5", result1),
                arguments("7+1.2/4-85", result2)
        );
    }

    // MathServiceTest

    public static Stream<Arguments> testOperation() {
        return Stream.of(
                arguments(7, 5, '+', 12),
                arguments(7, 5, '-', 2),
                arguments(6, 2, '/', 3)
        );
    }

    public static Stream<Arguments> testCalculate() {

        List<String> expression1 = new ArrayList<>();
        // 7+5
        expression1.add("7");
        expression1.add("5");
        expression1.add("+");

        List<String> expression2 = new ArrayList<>();
        // 7*5-3.4
        expression2.add("7");
        expression2.add("5");
        expression2.add("*");
        expression2.add("3.4");
        expression2.add("-");

        List<String> expression3 = new ArrayList<>();
        // .2-5*2-1/5
        expression3.add(".2");
        expression3.add("5");
        expression3.add("2");
        expression3.add("*");
        expression3.add("-");
        expression3.add("1");
        expression3.add("5");
        expression3.add("/");
        expression3.add("-");

        return Stream.of(
                arguments(expression1, 12),
                arguments(expression2, 31.6),
                arguments(expression3, -10)
        );
    }

}
