package com.javarush.pavlichenko.encoder.exceptions;

public class ShiftNotSetException extends IllegalStateException{
    public ShiftNotSetException() {
    }

    public ShiftNotSetException(String s) {
        super(s);
    }

    public ShiftNotSetException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShiftNotSetException(Throwable cause) {
        super(cause);
    }
}
