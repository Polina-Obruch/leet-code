package org.prefix_sum;

import java.io.*;

public class FindThePivotInteger {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            System.out.println(pivotInteger(readInt(reader)));
        }
    }

    public static int pivotInteger(int n) {
        int[] prefixSum = new int[n + 1];

        //В зависимости от условия подсчет префиксной суммы происходит по разному в разных задачах
        for (int i = 1; i < n + 1; ++i) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }

        // Граница входит в оба участка поэтому i + 1
        for (int i = 1; i < n + 1; ++i) {
            if (prefixSum[i] == (prefixSum[n] - prefixSum[n - (n - i + 1)])) {
                return i;
            }
        }
        return -1;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

/**
public class Solution {
    public int pivotInteger(int n) {
        // Initialize left and right pointers for binary search
        int left = 1, right = n;

        // Calculate the total sum of the sequence
        int totalSum = n * (n + 1) / 2;

        // Binary search for the pivot point
        while (left < right) {
            // Calculate the mid-point
            int mid = (left + right) / 2;

            // Check if the difference between the square of mid and the total sum is negative
            if (mid * mid - totalSum < 0) {
                left = mid + 1; // Adjust the left bound if the sum is smaller
            } else {
                right = mid; // Adjust the right bound if the sum is equal or greater
            }
        }

        // Check if the square of the left pointer minus the total sum is zero
        if (left * left - totalSum == 0) {
            return left;
        } else {
            return -1;
        }
    }
}
 */
