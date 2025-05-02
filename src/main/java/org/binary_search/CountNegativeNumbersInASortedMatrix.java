package org.binary_search;

public class CountNegativeNumbersInASortedMatrix {

    //Если элемент отрицательный, то все элементы под ним, в этом столбце, отрицательные
    public int countNegatives(int[][] grid) {
        int size = grid.length;
        int high = 0;
        int low = grid[0].length - 1;
        int countNegative = 0;

        while (high < size && low >= 0) {
            if (grid[high][low] < 0) {
                countNegative += size - high;
                --low;
            } else {
                ++high;
            }
        }

        return countNegative;
    }
}
