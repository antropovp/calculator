package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingServiceImpl implements ParsingService {

    private String[] operatorsPriority = {"[+\\-]", "[*/]"};

    public List<String> parseReversePolish(String expression) {

        List<String> resultString = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String element: expression.split("\\b")) {
            if (element.matches("\\d+")) {
                if (!resultString.isEmpty() && resultString.get(resultString.size() - 1).matches("[\\d]*\\.")) {
                    resultString.set(resultString.size() - 1, resultString.get(resultString.size() - 1) + element);
                } else {
                    resultString.add(element);
                }
            } else if (element.matches("[\\d]*\\.")) {
                if (!resultString.isEmpty() && resultString.get(resultString.size() - 1).matches("\\d+")) {
                    resultString.set(resultString.size() - 1, resultString.get(resultString.size() - 1) + element);
                } else {
                    resultString.add(element);
                }
            } else {
                for (int j = 0; j < operatorsPriority.length; j++) {
                    if (element.matches(operatorsPriority[j])) {
                        if (!operators.isEmpty()) {
                            if (operators.peek().matches(operatorsPriority[j])) {
                                resultString.add(operators.pop());
                                operators.push(element);
                            } else if ((j < operatorsPriority.length - 1)
                                    && operators.peek().matches(operatorsPriority[j + 1])) {
                                if (j == 0) {
                                    while (!operators.isEmpty()) {
                                        resultString.add(operators.pop());
                                    }
                                } else {
                                    while ((operators.peek().matches(operatorsPriority[j - 1]))) {
                                        resultString.add(operators.pop());
                                    }
                                }
                                operators.push(element);
                            } else {
                                operators.push(element);
                            }
                        } else {
                            operators.push(element);
                        }
                        break;
                    }
                }
            }
        }

        while (!operators.isEmpty()) {
            resultString.add(operators.pop());
        }

        return resultString;
    }
}
