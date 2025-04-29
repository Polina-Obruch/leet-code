package org.TopInterview;

public class CountSubArraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubArrays(int[] nums, int k) {
        //int max = Arrays.stream(nums).max().getAsInt();
        int max = nums[0];
        for (int e : nums) {
            max = Math.max(max, e);
        }
        //хранит начало новых комбинаций для нового окна
        //хранит количество комбинаций которые продолжаются на каждом шаге
        int start = 0;
        long result = 0;
        int countSizeMax = 0;

        for (int end = 0; end < nums.length; ++end) {
            if (nums[end] == max) {
                ++countSizeMax;
            }

            while (countSizeMax == k) {
                if (nums[start] == max) {
                    --countSizeMax;
                }
                ++start;
            }
            //Добавляем новые комбинации.
            //Так как start не обнуляется - учитываем и продолжение всех старых комбинаций
            //[3 3 3 1 2 1 2 1 2], к = 3
            //сначала добавили комбинацию 3 3 3 (result = 1)
            // а потом на каждой итерации продолжали ее 3 3 3 1 --- 3 3 3 1 2 ---
            result += start;
        }
        return result;
    }
}
