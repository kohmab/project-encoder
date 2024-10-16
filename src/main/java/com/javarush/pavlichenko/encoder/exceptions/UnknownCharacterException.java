package com.javarush.pavlichenko.encoder.exceptions;

public class UnknownCharacterException extends RuntimeException {
    public UnknownCharacterException() {
    }

    public UnknownCharacterException(String message) {
        super(message);
    }

    public UnknownCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCharacterException(Throwable cause) {
        super(cause);
    }
}
