package org.yandex;

import java.io.*;

public class EmoBoy {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String nick = reader.readLine();
            System.out.println(isTrue(nick));

        }
    }

    private static String isTrue(String nick) {
        boolean isNumber = false;
        boolean isUpperLetter = false;
        boolean isLetter = false;
        int size = nick.length();
        int i = 0;

        if (size < 8) {
            return NO;
        }

        while (i < size) {
            char currentChar = nick.charAt(i);

            if (Character.isDigit(nick.charAt(i))) {
                isNumber = true;
            } else if (Character.isUpperCase(currentChar)) {
                isUpperLetter = true;
            } else if (Character.isLowerCase(currentChar)) {
                isLetter = true;
            }

            if (isNumber && isUpperLetter && isLetter) {
                return YES;
            }

            ++i;
        }
        return NO;
    }
}
