package org.TopInterview;

import java.io.*;

public class Palindrome {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = reader.readLine();
            System.out.println(isPalindrome(line));
        }
    }

    public static boolean isPalindrome(String s) {
        int size = s.length();
        int left = 0;
        int right = size - 1;

        if (s.isEmpty()) {
            return true;
        }


        while (left <= right) {

            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                ++left;
            }

            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                --right;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;

        }

        return true;
    }

}
