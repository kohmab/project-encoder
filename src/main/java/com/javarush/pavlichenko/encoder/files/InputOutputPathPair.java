package com.javarush.pavlichenko.encoder.files;


import com.javarush.pavlichenko.encoder.assets.Strings;
import com.javarush.pavlichenko.encoder.exceptions.WrongFileException;
import lombok.Data;

import java.nio.file.Path;

@Data
public class InputOutputPathPair {
    private final Path inputPath;
    private final Path outputPath;

    public InputOutputPathPair(Path inputPath, Path outputPath) throws WrongFileException {
        if (inputPath.equals(outputPath))
            throw new WrongFileException(Strings.TEMPLATE_FAIL_EQUAL_PATHS);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }
}
