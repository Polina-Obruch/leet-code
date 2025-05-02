package org.prefix_sum;

public class LeftAndRightSumDifferencesForEachElements {

    public int[] leftRightDifference(int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        left[0] = 0;
        int[] right = new int[size];
        right[0] = 0;

        //Считаю левую и правую сумму для каждого элемента не включая его
        for (int i = 1; i < size; ++i) {
            left[i] = left[i - 1] + nums[i - 1];
            right[size - i - 1] = right[size -  i] + nums[size - i];
        }

        for (int i = 0; i < size; ++i) {
            nums[i] = Math.abs(left[i] - right[i]);
        }

        return nums;
    }
}
