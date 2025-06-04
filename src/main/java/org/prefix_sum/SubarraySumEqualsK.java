package org.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 A subarray is a contiguous non-empty sequence of elements within an array.
 **/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixIndex = new HashMap<>();
        prefixIndex.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            Integer index = prefixIndex.get(prefixSum - k);
            if (index != null) {
                count += index;
            }
            prefixIndex.merge(prefixSum, 1, (oldValue, newValue) -> ++oldValue);

        }
        return count;
    }
}

