package org.TopInterview;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//Храним последний индекс встреченного числа
public class ContainsDuplicateInArea {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
        }
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer currentIndex = indexes.get(nums[i]);

            if (currentIndex != null && Math.abs(i - currentIndex) <= k) {
                return true;
            }

            indexes.put(nums[i], i);

        }
        return false;
    }
}
