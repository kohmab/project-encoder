package com.javarush.pavlichenko.encoder.cipher;


import com.javarush.pavlichenko.encoder.exceptions.ShiftNotSetException;
import com.javarush.pavlichenko.encoder.exceptions.UnknownCharacterException;
import com.javarush.pavlichenko.encoder.exceptions.WrongFileException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.*;
import static java.util.Objects.isNull;

@Component("cipher")
@RequiredArgsConstructor
public class CaesarCipher implements Cipher {

    private final Alphabet alphabet;

    @Getter
    @Setter
    private Integer shift;


    @Override
    public void encode(InputStream input, OutputStream output) throws ShiftNotSetException, UnknownCharacterException, WrongFileException {
        checkConsistency();
        proceed(shift, input, output);
    }

    @Override
    public void decode(InputStream input, OutputStream output) throws ShiftNotSetException, UnknownCharacterException, WrongFileException {
        checkConsistency();
        proceed(-shift, input, output);
    }

    private void proceed(Integer signedShift, InputStream input, OutputStream output) throws WrongFileException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String proceededLine = proceedLine(signedShift, line);
                writer.write(proceededLine);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new WrongFileException(e);
        }
    }

    private String proceedLine(Integer signedShift, String line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            c = shiftChar(signedShift,c);
            sb.append(c);
        }
        return sb.toString();
    }

    private Character shiftChar(Integer signedShift, Character character) {
        if (!alphabet.contains(character)) {
            throw new UnknownCharacterException();
        }
        Integer val = (signedShift + alphabet.getInd(character)) % alphabet.getLenght();
        return alphabet.getChar(val);
    }

    private void checkConsistency() throws ShiftNotSetException {
        if (isNull(shift)) {
            throw new ShiftNotSetException();
        }


    }
}
