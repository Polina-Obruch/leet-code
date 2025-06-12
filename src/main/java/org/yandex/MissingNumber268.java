package org.yandex;

/**Given an array nums containing n distinct numbers in the range [0, n],
 *return the only number in the range that is missing from the array.
 **/
public class MissingNumber268 {

    //Используя сумму арифметической прогрессии
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = (size) * (size + 1) / 2;

        for (int i = 0; i < size; ++i) {
            sum -= nums[i];
        }

        return sum;
    }

    //Поиск через индекс
    public int missingNumberTwo(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }
}
