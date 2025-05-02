package org.TopInterview;

//Расчет индекса в цикличном массиве: (currentIndex + step) % sizeMassive
//Решение с доп. памятью
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] result = new int[size];

        for (int i = 0; i < size; ++i) {
            result[(i + k) % size] = nums[i];
        }

        for (int i = 0; i < size; ++i) {
            nums[i] = result[i];
        }
    }

    //Стандартное решение по повороту массива
    public void rotate_Another(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
