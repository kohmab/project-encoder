package com.javarush.pavlichenko.encoder;

import com.javarush.pavlichenko.encoder.cipher.CaesarCipher;
import com.javarush.pavlichenko.encoder.cipher.Cipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@CommandScan
public class ProjectEncoder2Application {


    public static void main(String[] args) {
        SpringApplication.run(ProjectEncoder2Application.class, args);
    }
}
