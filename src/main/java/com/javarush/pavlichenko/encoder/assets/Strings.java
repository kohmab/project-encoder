package com.javarush.pavlichenko.encoder.assets;

public class Strings {
    public final static String SET_SHIFT_COMMAND = "set-shift";
    public final static String SET_SHIFT_DESCRIPTION = "Set shift for Caesar's cipher encoder.";
    public final static String SET_SHIFT_TEMPLATE_OK = "Shift was set to value %d.";
    public final static String SET_SHIFT_PARAMETER_SHIFT_DESCRIPTION = "Shift value.";

    public final static String SHOW_ALPHABET_COMMAND = "show-alphabet";
    public final static String SHOW_ALPHABET_DESCRIPTION = "Print supported characters.";
    public final static String SHOW_ALPHABET_TEMPLATE_OK = "Characters set:\n BEGIN OF ALPHABET>>%s<<END OF ALPHABET";

    public final static String ENCRYPT_COMMAND = "encrypt";
    public final static String ENCRYPT_DESCRIPTION = "Encrypt input file and write ciphered text into output file.";
    public final static String ENCRYPT_TEMPLATE_OK = "File encrypted.";


    public final static String DECRYPT_COMMAND = "decrypt";
    public final static String DECRYPT_DESCRIPTION = "Decrypt input file and write ciphered text into output file.";
    public final static String DECRYPT_TEMPLATE_OK = "File decrypted.";

    public final static String TEMPLATE_FAIL_WRONG_ARGUMENT = "Wrong value of argument.\n";
    public final static String TEMPLATE_FAIL_WRONG_FILE = "Wrong file specified (%s).\n";
    public final static String TEMPLATE_FAIL_SHIFT_NOT_SET = "Set shift first by %s command.\n".formatted(SET_SHIFT_COMMAND);
    public final static String TEMPLATE_FAIL_EQUAL_PATHS = "Input and output path are equal.\n";
    public final static String TEMPLATE_FAIL_UNKNOWN_CHARACTER = "The input file contains characters that are not part of the alphabet.\n" +
            "Use %s command to see supported characters.\n".formatted(SHOW_ALPHABET_COMMAND);

    public final static String TEMPLATE_ENTER_INPUT_FILE_PATH = "Enter input file path...";
    public final static String TEMPLATE_ENTER_OUTPUT_FILE_PATH = "Enter output file path...";
}
