package com.epam.izh.rd.online.exception;

public class NullInputException extends Exception {

    public NullInputException() {
    }

    public NullInputException(String message) {
        super(message);
    }

    public NullInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullInputException(Throwable cause) {
        super(cause);
    }
}