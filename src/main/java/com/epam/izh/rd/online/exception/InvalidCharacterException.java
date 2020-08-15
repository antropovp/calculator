package com.epam.izh.rd.online.exception;

public class InvalidCharacterException extends Exception {

    public InvalidCharacterException() {
    }

    public InvalidCharacterException(String message) {
        super(message);
    }

    public InvalidCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCharacterException(Throwable cause) {
        super(cause);
    }
}