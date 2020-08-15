package com.epam.izh.rd.online.exception;

public class DoesNotEndWithNumber extends Exception {

    public DoesNotEndWithNumber() {
    }

    public DoesNotEndWithNumber(String message) {
        super(message);
    }

    public DoesNotEndWithNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public DoesNotEndWithNumber(Throwable cause) {
        super(cause);
    }
}