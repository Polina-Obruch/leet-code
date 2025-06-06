package org.yandex;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/** проверить, какое количество символов из S входит в J
 * Подготовка к собеседованию в Яндекс - A
 */
public class StonesAndJewelry {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String j = reader.readLine();
            String s = reader.readLine();

            System.out.println(getCountJew(j, s));

        }
    }


    public static int getCountJew(String j, String s) {
        Map<Character, Integer> counter = new HashMap<>();
        int result = 0;

        for (int i = 0; i < j.length(); ++i) {
            counter.put(j.charAt(i), i);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (counter.containsKey(s.charAt(i))) {
                ++result;
            }
        }
        return result;
    }
}
