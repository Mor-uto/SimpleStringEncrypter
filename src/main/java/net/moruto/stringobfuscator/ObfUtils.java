package net.moruto.stringobfuscator;

import java.util.Base64;
import java.util.HashMap;

public class ObfUtils {
    public static HashMap<Character, Character> obf = new HashMap<>();

    static {
        obf.put('a', 'p');
        obf.put('b', 'o');
        obf.put('c', 'i');
        obf.put('d', 'u');
        obf.put('e', 'y');
        obf.put('f', 't');
        obf.put('g', 'r');
        obf.put('h', 'e');
        obf.put('i', 'w');
        obf.put('j', 'q');
        obf.put('k', 'a');
        obf.put('l', 's');
        obf.put('m', 'd');
        obf.put('n', 'f');
        obf.put('o', 'g');
        obf.put('p', 'h');
        obf.put('q', 'j');
        obf.put('r', 'k');
        obf.put('s', 'l');
        obf.put('t', 'z');
        obf.put('u', 'x');
        obf.put('v', 'c');
        obf.put('w', 'v');
        obf.put('x', 'b');
        obf.put('y', 'n');
        obf.put('z', 'm');
    }

    public static String obfuscateString(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append("x8n");

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (obf.containsKey(letter)) {
                char letterToReplace = obf.get(letter);
                builder.append(letterToReplace);
            } else {
                builder.append(letter);
            }
        }

        return Base64.getEncoder().encodeToString(builder.toString().getBytes());
    }

    public static String deobfuscateString(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str);
        String decodedString = new String(decodedBytes);
        StringBuilder builder = new StringBuilder();
        String cleanedString = decodedString.substring(3);

        for (int i = 0; i < cleanedString.length(); i++) {
            char letter = cleanedString.charAt(i);
            if (obf.containsValue(letter)) {
                for (char key : obf.keySet()) {
                    if (obf.get(key) == letter) {
                        builder.append(key);
                        break;
                    }
                }
            } else {
                builder.append(letter);
            }
        }

        return builder.toString();
    }
}
