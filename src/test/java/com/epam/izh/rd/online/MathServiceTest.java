package com.epam.izh.rd.online;

import com.epam.izh.rd.online.service.MathService;
import com.epam.izh.rd.online.service.MathServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {

    private MathService mathService;

    @BeforeAll
    private void setup() {
        mathService = new MathServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testOperation")
    @DisplayName("Тест метода MathService.operation(double operand1, double operand2, char operator)")
    void testOperation(double param1, double param2, char param3, double expected) {
        assertEquals(expected, mathService.operation(param1, param2, param3),
                "Для входных параметров: " + param1 + " " + param2 + " " + param3);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testCalculate")
    @DisplayName("Тест метода MathService.calculate(List<String> expression)")
    void testCalculate(List<String> param, double expected) {
        assertEquals(expected, mathService.calculate(param), "Для входного параметра: " + param);
    }
}
