package org.TopInterview;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        //int right = 0;
        int currentTarget = 0;
        int minSize = Integer.MAX_VALUE;

        //Решение со скользящим окном
        for (int right = 0; right < nums.length; ++right) {
            currentTarget += nums[right];

            while (currentTarget >= target) {
                minSize = Math.min(minSize, right - left + 1);
                currentTarget -= nums[left];
                ++left;
            }

        }

        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }

        return minSize;
    }
}
