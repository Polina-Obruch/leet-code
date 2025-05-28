package org.prefix_sum;

import java.io.*;

/**
    You are given an integer array nums of size n.
    For each index i where 0 <= i < n, define a subarray nums[start ... i] where start = max(0, i - nums[i]).
    Return the total sum of all elements from the subarray defined for each index in the array.
 **/

public class SumOfVariableLengthSubArrays {

    public static void main(String[] args) throws IOException {
        System.out.println(subarraySum(new int[]{3, 1, 1, 2}));
    }
    public static int subarraySum(int[] nums) {
        int size = nums.length;
        int[] prefix = new int[size];
        prefix[0] = nums[0];
        int result = 0;

        for (int i = 1; i < size; ++i) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        for (int i = 0; i < size; ++i) {
            int start = Math.max(0, i - nums[i]);

            if (start == 0) {
                result += prefix[i];
            } else {
                result += prefix[i] - prefix[start - 1];
            }
        }

        return result;

    }
}
