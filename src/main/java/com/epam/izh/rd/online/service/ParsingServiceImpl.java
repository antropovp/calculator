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
                resultString.add(element);
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
            }
        }

        while (!operators.isEmpty()) {
            resultString.add(operators.pop());
        }

        return resultString;
    }


}
