package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class ParsingServiceImpl implements ParsingService {

    public List<String> parseReversedPolish(String expression) {

        List<String> resultString = new ArrayList<String>();
        Stack<String> operators = new Stack<String>();

        for (String element: expression.split("\\b")) {
            if (element.matches("\\d")) {
                resultString.add(element);
            } else if ((element == "+") || (element == "-")) {
                operators.push(element);
            } else if ((element == "*") || (element == "/")) {
                if ((operators.peek() != "*") || (operators.peek() != "/")) {
                    operators.push(element);
                } else {
                    resultString.add(element);
                }
            }
        }

        for (String element: operators) {
            resultString.add(operators.pop());
        }

        return resultString;
    }


}
