package com.javarush.pavlichenko.encoder.exceptions;

import java.io.IOException;

public class WrongFileException extends Exception {
    public WrongFileException() {
    }

    public WrongFileException(String message) {
        super(message);
    }

    public WrongFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFileException(Throwable cause) {
        super(cause);
    }
}
