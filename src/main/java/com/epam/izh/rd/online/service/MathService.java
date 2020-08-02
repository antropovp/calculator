package com.epam.izh.rd.online.service;

import java.util.List;

public interface MathService {

    double calculate(List<String> expression);
    double operation(double operand1, double operand2, char operator);
}
