package org.TopInterview;

import java.io.*;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] line = reader.readLine().split(",");
            int[] numbers = new int[line.length];
            for (int i = 0; i < line.length; ++i) {
                numbers[i] = Integer.parseInt(line[i]);
            }
            System.out.println(removeDuplicates(numbers));


        }
    }

    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int k = 0;

        for (int i = 0; i < size; ++i) {
            int currentNumber = nums[i];
            nums[k] = currentNumber;
            ++k;
            while (i + 1 < size && nums[i + 1] == currentNumber ) {
                ++i;
            }
        }
        return k;
    }
}
