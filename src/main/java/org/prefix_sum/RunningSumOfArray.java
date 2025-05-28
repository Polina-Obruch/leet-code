package org.prefix_sum;

/**
    Given an array nums.
    We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 **/

public class RunningSumOfArray {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for(int i = 1; i<n ; i++){
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;
    }
}
