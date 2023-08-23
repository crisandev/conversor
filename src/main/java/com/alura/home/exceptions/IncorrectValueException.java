package com.alura.home.exceptions;

public class IncorrectValueException extends Exception {

    public IncorrectValueException() {
        super("This is a custom exception.");
    }

    public IncorrectValueException(String message) {
        super(message);
    }

}
