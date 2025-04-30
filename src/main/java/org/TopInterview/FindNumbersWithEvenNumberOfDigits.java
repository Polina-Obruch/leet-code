package org.TopInterview;

//Можно перевести числа в строку и посчитать ее длину
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count = 1;
            int currentPart = nums[i] / 10;

            while (currentPart > 0) {
                currentPart = currentPart / 10;
                ++count;
            }

            if (count % 2 == 0) {
                ++result;
            }
        }
        return result;
    }

    //Просто выборкой диапазона
    public int findNumbers_Another(int[] nums) {
        int result = 0;
        for (int number: nums) {
            if ((number > 9 && number < 100) || (number > 999 && number < 10000) || (number == 100000)) result++;
        }
        return result;
    }
}
