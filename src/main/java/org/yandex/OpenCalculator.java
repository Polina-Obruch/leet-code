package org.yandex;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            Set<Integer> addButton = new HashSet<>();
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int z = Integer.parseInt(tokenizer.nextToken());
            String number = reader.readLine();

            for (int i = 0; i < number.length(); ++i) {
                int currentChar = Integer.parseInt(String.valueOf(number.charAt(i)));
                if (currentChar != x && currentChar != y && currentChar != z) {
                    addButton.add(currentChar);
                }
            }
            System.out.println(addButton.size());
        }
    }
}
