package org.yandex;

/** Given a string s, return the longest palindromic substring in s.**/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int end = 0;
        int currentLength = 1;

        for (int i = 0; i < length; ++i) {
            //Два варианта палиндрома с центральным элементом и без него: s1 = abcba  s2 = abccba
            int withOutCenter = getLength(s, i, i + 1);
            int withCenter = getLength(s, i, i);
            int maxLength = Math.max(withOutCenter, withCenter);

            if (currentLength < maxLength) {
                currentLength = maxLength;
                int half = currentLength / 2;
                if (currentLength % 2 == 0) {
                    start = i - half + 1;
                } else {
                    start = i - half;
                }
                end = i + half;
            }
        }

        return s.substring(start, end + 1);
    }

    private int getLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
