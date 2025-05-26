package org.TopInterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceUnSortedArray {
    public int longestConsecutive(int[] nums) {
        Set<Integer> indexes = new HashSet<>();
        for (int num : nums) {
            indexes.add(num);
        }

        int result = 0;

        for (int currentNum : nums) {
            int currentNumPlus = currentNum + 1;
            int currentNumMinus = currentNum - 1;
            int currentLong = 1;

            if (indexes.contains(currentNum)) {
                //Удаление для того, чтобы не пересчитывать подпоследовательности заново
                indexes.remove(currentNum);

                while (indexes.contains(currentNumPlus)) {
                    indexes.remove(currentNumPlus);
                    ++currentLong;
                    ++currentNumPlus;
                }

                while (indexes.contains(currentNumMinus)) {
                    indexes.remove(currentNumMinus);
                    ++currentLong;
                    --currentNumMinus;
                }

            }

            result = Math.max(result, currentLong);
        }
        return result;
    }

    //???Если отсортировать массив
    public int longestConsecutiveTwo(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int currentLong = 1;
        int result = 0;

        if (size == 0) {
            return 0;
        }

        if (size == 1) {
            return 1;
        }

        for (int i = 1; i < size;++i) {
            if (nums[i] == nums[i - 1] + 1) {
                currentLong++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                result = Math.max(result, currentLong);
                currentLong = 1;
            }
        }

        return Math.max(currentLong, result);
    }
}
