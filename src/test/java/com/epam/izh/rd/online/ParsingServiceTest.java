package com.epam.izh.rd.online;

import com.epam.izh.rd.online.service.ParsingService;
import com.epam.izh.rd.online.service.ParsingServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingServiceTest {

    private static ParsingService parsingService;

    @BeforeAll
    static void setup() {
        parsingService = new ParsingServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testParseReversePolish")
    @DisplayName("Тест метода ParsingService.parseReversePolish(String expression)")
    void testParseReversePolish(String param, List<String> expected) {
        assertEquals(expected, parsingService.parseReversePolish(param), "Для входного параметра: " + param);
    }

}