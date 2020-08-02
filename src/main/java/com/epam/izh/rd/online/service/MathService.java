package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public interface MathService {

    double calculate(List<String> expression);
    double operation(double operand1, double operand2, char operator);
}
