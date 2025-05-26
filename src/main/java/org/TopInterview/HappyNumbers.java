package org.TopInterview;

import java.util.HashSet;
import java.util.Set;

/** Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.
 **/

public class HappyNumbers {
    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();

        //Для отлова цикла
        while (!numbers.contains(n)) {
            numbers.add(n);
            if (n == 1) {
                return true;
            } else {
                int current = 0;
                //Отделение цифр числа
                while (n > 0) {
                    int digit = n % 10;
                    current += digit * digit;
                    n = n / 10;
                }
                n = current;
            }
        }
        return false;
    }

    //Подборка параметров для цифр
    public boolean isHappyTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 7) {
            return true;
        } else if (n < 10) {
            return false;
        }
        int tempSum = 0;
        while (n > 0) {
            int temp = n % 10;
            tempSum += temp * temp;
            n = n / 10;
        }
        return isHappy(tempSum);
    }
}
