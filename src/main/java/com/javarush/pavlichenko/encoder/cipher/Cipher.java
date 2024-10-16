package com.javarush.pavlichenko.encoder.cipher;

import com.javarush.pavlichenko.encoder.exceptions.WrongFileException;

import java.io.InputStream;
import java.io.OutputStream;

public interface Cipher {
    void encode(InputStream input, OutputStream output) throws WrongFileException;
    void decode(InputStream input, OutputStream output) throws WrongFileException;
}
