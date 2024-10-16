package com.javarush.pavlichenko.encoder.cipher;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component("alphabet")
public class Alphabet {
    private final Character[] alphabet =
            {
                    'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К',
                    'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
                    'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
                    'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к',
                    'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                    'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ',
            };

    private final Map<Character, Integer> indexes;

    private final Map<Integer, Character> characters;

    private final Set<Character> characterSet = Set.of(alphabet);

    public int getLenght() {
        return alphabet.length;
    }

    public boolean contains(char c) {
        return characterSet.contains(c);
    }

    public Integer getInd(Character c) {
        return indexes.get(c);
    }

    public Character[] getAllChars() {
        return alphabet;
    }

    public Character getChar(Integer ind) {
        return characters.get(ind);
    }

    {
        Map<Character, Integer> ci = new HashMap<>();
        Map<Integer, Character> ic = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            ci.put(alphabet[i], i);
            ic.put(i, alphabet[i]);
        }
        characters = Collections.unmodifiableMap(ic);
        indexes = Collections.unmodifiableMap(ci);

    }


}
