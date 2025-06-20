package org.top75;

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        int one = 0;
        int two = 0;
        StringBuilder builder = new StringBuilder();
        while (one < word1.length() && two < word2.length()) {
            builder.append(word1.charAt(one)).append(word2.charAt(two));
            ++one;
            ++two;
        }

        if (one < word1.length()) {
            builder.append(word1.substring(one));
        }

        if (two < word2.length()) {
            builder.append(word2.substring(two));
        }

        return builder.toString();
    }
}
