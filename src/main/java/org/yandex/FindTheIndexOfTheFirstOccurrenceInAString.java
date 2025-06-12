package org.yandex;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    //Чуть лучше
    public int strStrNew(String haystack, String needle) {
        int indexNeedle = 0;
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength > haystackLength) {
            return -1;
        }

        for (int i = 0; i < haystackLength; ++i) {
            if (needle.charAt(indexNeedle) == haystack.charAt(i)) {
                ++indexNeedle;

                if (indexNeedle >= needleLength) {
                    return i + 1 - needleLength;
                }
            } else {
                if (indexNeedle > 0) {
                    i = i - indexNeedle;
                    indexNeedle = 0;
                }
            }
        }

        return -1;
    }



    //Ужасный вариант
    public int strStr(String haystack, String needle) {
        int indexStack = 0;
        int indexNeedle = 0;
        int start = Integer.MAX_VALUE;

        if (needle.length() > haystack.length()) {
            return -1;
        }

        while (indexStack < haystack.length() && indexNeedle < needle.length()) {
            if (haystack.charAt(indexStack) == needle.charAt(indexNeedle)) {
                start = Math.min(start, indexStack);
                ++indexStack;
                ++indexNeedle;
            } else {
                if (start != Integer.MAX_VALUE) {
                    indexStack = start;
                }
                ++indexStack;
                indexNeedle = 0;
                start = Integer.MAX_VALUE;
            }
        }

        if (start == Integer.MAX_VALUE || indexNeedle < needle.length() ) {
            return -1;
        } else {
            return start;
        }
    }
}
