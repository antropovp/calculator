package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingServiceImpl implements ParsingService {

    public List<String> parseReversedPolish(String expression) {

        List<String> resultString = new ArrayList<String>();
        Stack<String> operators = new Stack<String>();
        
        for (String element: expression.split("\\b")) {
            if (element.matches("\\d+")) {
                if (!resultString.isEmpty() && resultString.get(resultString.size() - 1).matches("[\\d]*\\.")) {
                    resultString.set(resultString.size() - 1, resultString.get(resultString.size() - 1) + element);
                } else {
                    resultString.add(element);
                }
            } else if ((element.equals("+")) || (element.equals("-"))) {
                if (!operators.isEmpty()) {
                    if ((operators.peek().equals("+")) || (operators.peek().equals("-"))) {
                        resultString.add(operators.pop());
                        operators.push(element);
                    } else if ((operators.peek().equals("*")) || (operators.peek().equals("/"))) {
                        while (!operators.isEmpty()) {
                            resultString.add(operators.pop());
                        }
                        operators.push(element);
                    } else {
                        operators.push(element);
                    }
                } else {
                    operators.push(element);
                }
            } else if ((element.equals("*")) || (element.equals("/"))) {
                if (!operators.isEmpty()) {
                    if ((operators.peek().equals("*")) || (operators.peek().equals("/"))) {
                        resultString.add(operators.pop());
                        operators.push(element);
                    } else {
                        operators.push(element);
                    }
                } else {
                    operators.push(element);
                }
            } else if (element.matches("[\\d]*\\.")) {
                if (!resultString.isEmpty() && resultString.get(resultString.size() - 1).matches("\\d+")) {
                    resultString.set(resultString.size() - 1, resultString.get(resultString.size() - 1) + element);
                } else {
                    resultString.add(element);
                }
            }
        }

        while (!operators.isEmpty()) {
            resultString.add(operators.pop());
        }

        return resultString;
    }


}
