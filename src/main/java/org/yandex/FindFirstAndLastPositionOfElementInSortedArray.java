package org.yandex;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[] {-1, -1};

        //Поиск самого первого вхождения
        while (left <= right) {
            int mid = left + (right - left) / 2 ;
            int current = nums[mid];

            if (current < target){
                left = ++mid;
            } else if (current == target){
                result[0] = mid;
                right = --mid;
            } else {
                right = --mid;
            }
        }

        left = 0;
        right = nums.length - 1;

        //Поиск самого последнего вхождения
        while (left <= right) {
            int mid = left + (right - left) / 2 ;
            int current = nums[mid];

            if (current > target){
                right = --mid;
            } else if (current == target) {
                result[1] = mid;
                left = ++mid;
            } else {
                left = ++mid;
            }
        }

        return result;
    }
}
