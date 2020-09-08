package com.epam.izh.rd.online.service;

import java.util.List;

public class MathServiceImpl implements MathService {

    public double calculate(List<String> expression) {

        while (expression.size() > 1) {

            for (int i = 0; i < expression.size(); i++) {

                if (expression.get(i).matches("\\D")) {
                    expression.set(i - 2, String.valueOf(operation(Double.parseDouble(expression.get(i - 2)),
                            Double.parseDouble(expression.get(i - 1)), expression.get(i).charAt(0))));
                    expression.remove(i);
                    expression.remove(i - 1);
                    i -= 2;
                }
            }
        }

        return Double.parseDouble(expression.get(0));
    }

    public double operation(double operand1, double operand2, char operator) {

        double result = 0;

        try {
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
                    if (operand2 == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero.");
                    }
                    result = operand1 / operand2;
                    break;
            }
        } catch (IllegalArgumentException e) {
            result = 0;
            System.out.println(e.getMessage() + " Result is set to 0.");
        }

        return result;
    }
}
