package com.javarush.pavlichenko.encoder.files;

import org.springframework.shell.standard.ShellComponent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@ShellComponent
public class FileManager {

    public OutputStream getOutputStream(Path outputPath) throws IOException {
        createIfAbsent(outputPath);
        return Files.newOutputStream(outputPath);
    }

    public OutputStream getOutputStream(InputOutputPathPair pair) throws IOException {
        return getOutputStream(pair.getOutputPath());
    }

    public InputStream getInputStream(Path inputPath) throws IOException {
        return Files.newInputStream(inputPath);
    }

    public InputStream getInputStream(InputOutputPathPair pair) throws IOException {
        return getInputStream(pair.getInputPath());
    }

    public InputOutputStreamPair getStreams(InputOutputPathPair pair) throws IOException {
        InputStream inputStream = getInputStream(pair);
        OutputStream outputStream = getOutputStream(pair);
        return new InputOutputStreamPair(inputStream, outputStream);
    }

    private void createIfAbsent(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);

        }
    }

}
