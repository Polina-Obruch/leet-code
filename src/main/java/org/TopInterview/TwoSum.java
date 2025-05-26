package org.TopInterview;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer currentIndex = indexes.get(target - nums[i]);
            if (currentIndex != null) {
                return new int[]{i, currentIndex};
            } else {
                indexes.put(nums[i], i);
            }
        }

        //если ответа нет
        return null;


    }
}
