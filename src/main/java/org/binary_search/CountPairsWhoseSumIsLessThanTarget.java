package org.binary_search;

import java.util.Collections;
import java.util.List;

//Почему-то решение с двумя циклами for на leetcode лучше...
public class CountPairsWhoseSumIsLessThanTarget {

        public int countPairs(List<Integer> nums, int target) {
            Collections.sort(nums);
            int left = 0;
            int right = nums.size() - 1;
            int countPair = 0;

            while (left < right) {
                if (nums.get(left) + nums.get(right) < target) {
                    //Комбинация суммы left с каждым right - 1...
                    countPair += right - left;
                    ++left;
                } else  {
                    --right;
                }
            }

            return countPair;

        }
}
