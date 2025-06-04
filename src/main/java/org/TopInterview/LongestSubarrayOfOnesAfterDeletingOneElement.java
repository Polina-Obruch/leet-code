package org.TopInterview;

public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int leftZero = -1;
        boolean isFirstZero = true;
        int length = 0;
        int currentLength = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (isFirstZero) {
                    isFirstZero = false;
                } else {
                    length = Math.max(length, currentLength);
                    currentLength = i - leftZero - 1;
                }

                leftZero = i;
            } else {
                ++currentLength;
            }
        }

        if (isFirstZero) {
            //Так как если весь массив только из единиц, то надо все равно удалить один элемент
            return --currentLength;
        } else {
            return Math.max(length, currentLength);
        }
    }
}
