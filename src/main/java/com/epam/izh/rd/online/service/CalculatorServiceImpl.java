package com.epam.izh.rd.online.service;

public class CalculatorServiceImpl {

    private ConsoleService consoleService = new ConsoleServiceImpl();
    private InputValidator inputValidator = new InputValidatorImpl();
    private ParsingService parsingService = new ParsingServiceImpl();
    private MathService mathService = new MathServiceImpl();

    private String input;

    public void start() {

        System.out.print("Write the expression: ");
        input = consoleService.read();

        while (!inputValidator.validate(input)) {
            System.out.println("Invalid input. Try again.");
            input = consoleService.read();
        }

        System.out.print("= " + mathService.calculate(parsingService.parseReversePolish(input)));
    }
}
