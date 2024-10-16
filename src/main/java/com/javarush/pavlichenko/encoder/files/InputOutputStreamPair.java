package com.javarush.pavlichenko.encoder.files;

import lombok.Data;

import java.io.InputStream;
import java.io.OutputStream;

@Data
public class InputOutputStreamPair implements AutoCloseable {
    private final InputStream input;
    private final OutputStream output;

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
    }
}
