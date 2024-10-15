package com.javarush.pavlichenko.encoder;

import com.javarush.pavlichenko.encoder.cipher.CaesarCipher;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@ShellComponent
@Command(group = "commands")
@RequiredArgsConstructor
public class ConsoleCommands {


    private final CaesarCipher cipher;

    @Command(command="test", description = "")
    public String test(){
        String testLine = "абвгде";
        InputStream input = new ByteArrayInputStream(testLine.getBytes(StandardCharsets.UTF_8));
        OutputStream output = new ByteArrayOutputStream();

        cipher.setShift(200);
        cipher.encode(input,output);
        return output.toString();
    }



//    @Override
//    public void run(String... args) throws Exception {
//
//    }
}
