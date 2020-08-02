package com.epam.izh.rd.online.service;

import java.util.List;

public class MathServiceImpl implements MathService {

    public double calculate(List<String> expression) {

        double result = 0;

        for (int i = 1; i < expression.size() - 1; i+=2) {
            result = operation(result, Double.parseDouble(expression.get(i + 1)), expression.get(i).charAt(0));
        }

        return result;
    }

    public double operation(double operand1, double operand2, char operator) {

        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

        return result;
    }
}
