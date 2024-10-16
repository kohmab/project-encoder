package com.javarush.pavlichenko.encoder.controller;

import com.javarush.pavlichenko.encoder.assets.Strings;
import com.javarush.pavlichenko.encoder.exceptions.ShiftNotSetException;
import com.javarush.pavlichenko.encoder.exceptions.UnknownCharacterException;
import com.javarush.pavlichenko.encoder.exceptions.WrongFileException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class CommandExceptionResolverImpl implements CommandExceptionResolver {
    @Override
    public CommandHandlingResult resolve(Exception ex) {
        if (ex instanceof ConversionFailedException)
            return CommandHandlingResult.of(Strings.TEMPLATE_FAIL_WRONG_ARGUMENT);

        if (ex instanceof ShiftNotSetException) {
            return CommandHandlingResult.of(Strings.TEMPLATE_FAIL_SHIFT_NOT_SET);
        }

        if (ex instanceof WrongFileException)
            return CommandHandlingResult.of(Strings.TEMPLATE_FAIL_WRONG_FILE.formatted(ex.getMessage()));

        if (ex instanceof UnknownCharacterException)
            return CommandHandlingResult.of(Strings.TEMPLATE_FAIL_UNKNOWN_CHARACTER.formatted(ex.getMessage()));

        return null;
    }
}