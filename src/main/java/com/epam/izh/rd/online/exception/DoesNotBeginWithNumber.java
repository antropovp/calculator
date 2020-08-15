package com.epam.izh.rd.online.exception;

public class DoesNotBeginWithNumber extends Exception {

    public DoesNotBeginWithNumber() {
    }

    public DoesNotBeginWithNumber(String message) {
        super(message);
    }

    public DoesNotBeginWithNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public DoesNotBeginWithNumber(Throwable cause) {
        super(cause);
    }
}