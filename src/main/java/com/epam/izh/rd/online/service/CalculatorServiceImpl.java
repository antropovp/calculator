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

        boolean isValid = false;
        do {
            input = consoleService.read();

            try {
                isValid = inputValidator.validate(input);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.println("Invalid input. Try again.");
            }
        } while (isValid == false);

        System.out.print("= " + mathService.calculate(parsingService.parseReversePolish(input)));
    }
}
