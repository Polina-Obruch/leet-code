package org.TopInterview;

public class JumpGame55 {

    //O(n)
    public boolean canJumpTwo(int[] nums) {
        int size = nums.length;
        int end = size - 1;
        boolean result = true;
        for (int i = size - 2; i >= 0; --i) {
            if (nums[i] + i >= end) {
                end = i;
                result = true;
            } else {
                result = false;
            }

        }

        //Можно возвращать end == 0;
        return result;
    }
    //O(n^2)
    public boolean canJump(int[] nums) {
        int size = nums.length;
        boolean[] isPossible = new boolean[size];
        isPossible[0] = true;

        for (int i = 0; i < size; ++i) {
            if (isPossible[i]) {
                int max = nums[i];
                int j = 1;

                while (j <= max && i + j < size) {
                    isPossible[i + j] = true;
                    ++j;
                }
            }

            if (isPossible[size - 1]) {
                return true;
            }
        }

        return false;
    }
}
