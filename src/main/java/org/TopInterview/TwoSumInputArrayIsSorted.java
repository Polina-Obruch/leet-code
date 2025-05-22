package org.TopInterview;

//Сложность O(n)
public class TwoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while ((numbers[right] + numbers[left]) != target) {
            if (numbers[right] + numbers[left] > target) {
                --right;
            } else {
                ++left;
            }
        }

        result[0] = ++left;
        result[1] = ++right;
        return result;
    }
}
