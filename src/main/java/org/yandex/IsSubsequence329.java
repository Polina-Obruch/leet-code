package org.yandex;
/**
 Given two strings s and t, return TRUE if s is a subsequence of t, or FALSE otherwise.
 A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 the characters without disturbing the relative positions of the remaining characters.
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence329 {
    public boolean isSubsequence(String s, String t) {
        int sizeS = s.length();
        int sizeT = t.length();
        int slow = 0;
        int fast = 0;

        if (s.isEmpty()) {
            return true;
        }

        if (sizeT < sizeS) {
            return false;
        }

        while (fast < sizeT) {
            if (t.charAt(fast) == s.charAt(slow)) {
                ++slow;
                if (slow == sizeS) {
                    return true;
                }
            }
            ++fast;
        }
        return false;
    }
}
