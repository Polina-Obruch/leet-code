package org.TopInterview;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//Сложность O(n)
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            System.out.println(lengthOfLongestSubstring(reader.readLine()));
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> substring = new HashMap();
        int result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            Integer current = substring.get(s.charAt(i));
            if (current != null) {
                if (current >= start) {
                    start = ++current;
                }
            }

            substring.put(s.charAt(i), i);
            result = Math.max(result, i - start + 1);

        }
        return result;
    }
}
