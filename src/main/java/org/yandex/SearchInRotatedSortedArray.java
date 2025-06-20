package org.yandex;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        search(new int[]{4,5,6,7,0,1,2}, 0);
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];

            if (cur == target) {
                return mid;
            } else if (nums[left] <= cur) {
                if (cur > target && target >= nums[left]) {
                    right = --mid;
                } else {
                    left = ++mid;
                }
            } else {
                if (cur < target && target <= nums[right]) {
                    left = ++mid;
                } else {
                    right = --mid;
                }
            }
        }

        return idx;
    }
}
