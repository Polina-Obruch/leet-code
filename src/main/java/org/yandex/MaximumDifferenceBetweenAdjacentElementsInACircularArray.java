package org.yandex;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int result  =  0;
        for (int i = 0; i < nums.length; ++i) {
            if (i + 1 == nums.length) {
                //Можно вынести из цикла и инициализировать result
                result = Math.max(result, Math.abs(nums[i] - nums[0]));
            } else {
                result = Math.max(result, Math.abs(nums[i] - nums[i + 1]));
            }

        }
        return result;
    }
}
