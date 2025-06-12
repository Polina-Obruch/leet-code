package org.yandex;


import java.util.ArrayList;
import java.util.List;

/**Given an m x n matrix, return all elements of the matrix in spiral order.**/

// x -> проход по значениям каждого столбца одной строки (лево право)
// y ->  проход по значениям строк одного столбца (верх вниз)

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> result = new ArrayList<>(row * column);

        int x = 0;
        int y = 0;

        int dx = 1;
        int dy = 0;

        for (int i = 0; i < row * column; ++i) {
            result.add(matrix[y][x]);
            //Используем для новой границы
            matrix[y][x] = 101;
            int stepX = x + dx;
            int stepY = y + dy;

            if (stepX == -1 || stepX == column || stepY == -1 || stepY == row || matrix[stepY][stepX] == 101) {
                int tmp = dx;
                dx = -1 * dy;
                dy = tmp;
            }
            x += dx;
            y += dy;
        }

        return result;
    }

    //Алгоритм без изменения исходного массива
    public List<Integer> spiralOrderTwo(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;

        while (left <= right && top <= bottom) {
            // Traverse right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse down
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse left (if we still have rows)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse up (if we still have columns)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
