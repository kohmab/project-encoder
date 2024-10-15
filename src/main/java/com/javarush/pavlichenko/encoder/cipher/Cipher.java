package com.javarush.pavlichenko.encoder.cipher;

import java.io.InputStream;
import java.io.OutputStream;

public interface Cipher {
    void encode(InputStream input, OutputStream output);
    void decode(InputStream input, OutputStream output);
}
