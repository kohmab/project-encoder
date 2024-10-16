package com.javarush.pavlichenko.encoder.controller;

import com.javarush.pavlichenko.encoder.assets.Strings;
import com.javarush.pavlichenko.encoder.cipher.Alphabet;
import com.javarush.pavlichenko.encoder.exceptions.ShiftNotSetException;
import com.javarush.pavlichenko.encoder.exceptions.WrongFileException;
import com.javarush.pavlichenko.encoder.files.FileManager;
import com.javarush.pavlichenko.encoder.cipher.CaesarCipher;
import com.javarush.pavlichenko.encoder.files.InputOutputPathPair;
import com.javarush.pavlichenko.encoder.files.InputOutputStreamPair;
import lombok.RequiredArgsConstructor;


import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.component.PathInput;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@ShellComponent
@Command(group = "commands")
@RequiredArgsConstructor
public class ConsoleController extends AbstractShellComponent {


    private final CaesarCipher cipher;

    private final FileManager fileManager;

    private final Alphabet alphabet;

    @Command(command = Strings.SET_SHIFT_COMMAND, description = Strings.SET_SHIFT_DESCRIPTION)
    public String setShift(@Option(required = true, description = Strings.SET_SHIFT_PARAMETER_SHIFT_DESCRIPTION)
                           Integer shift) {

        cipher.setShift(shift);
        return Strings.SET_SHIFT_TEMPLATE_OK.formatted(shift);
    }

    @Command(command = Strings.ENCRYPT_COMMAND, description = Strings.ENCRYPT_DESCRIPTION)
    public String encrypt() throws Exception {
        InputOutputPathPair pair = getInputOutputPaths();
        try (InputOutputStreamPair streams = fileManager.getStreams(pair)) {
            InputStream input = streams.getInput();
            OutputStream output = streams.getOutput();
            cipher.encode(input, output);
            return Strings.ENCRYPT_TEMPLATE_OK;

        } catch (IOException e) {
            throw new WrongFileException(e.getMessage());
        }
    }

    @Command(command = Strings.DECRYPT_COMMAND, description = Strings.DECRYPT_DESCRIPTION)
    public String decrypt() throws Exception {
        InputOutputPathPair pair = getInputOutputPaths();
        try (InputOutputStreamPair streams = fileManager.getStreams(pair)) {
            InputStream input = streams.getInput();
            OutputStream output = streams.getOutput();
            cipher.decode(input, output);
            return Strings.DECRYPT_TEMPLATE_OK;

        } catch (IOException e) {
            throw new WrongFileException(e.getMessage());
        }
    }

    @Command(command = Strings.SHOW_ALPHABET_COMMAND, description = Strings.SHOW_ALPHABET_DESCRIPTION)
    public String showAlphabet() {
        String result =
                Arrays.stream(alphabet.getAllChars())
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        return Strings.SHOW_ALPHABET_TEMPLATE_OK.formatted(result);
    }

    private InputOutputPathPair getInputOutputPaths() throws WrongFileException {
        PrintWriter writer = getTerminal().writer();
        writer.println(Strings.TEMPLATE_ENTER_INPUT_FILE_PATH);
        Path input = getPath();
        writer.println(Strings.TEMPLATE_ENTER_OUTPUT_FILE_PATH);
        Path output = getPath();
        return new InputOutputPathPair(input, output);
    }

    private Path getPath() {

        PathInput component = new PathInput(getTerminal(), "path :");
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        PathInput.PathInputContext context = component.run(PathInput.PathInputContext.empty());
        return context.getResultValue().toAbsolutePath();

    }


}
