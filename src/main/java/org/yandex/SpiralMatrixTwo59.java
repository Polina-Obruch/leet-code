package org.yandex;


public class SpiralMatrixTwo59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;

        int dx = 1;
        int dy = 0;

        for (int i = 1; i <= n * n; ++i) {
            matrix[y][x] = i;
            int stepX = x + dx;
            int stepY = y + dy;

            if (stepX >= n || stepY >= n || stepX < 0 || stepY < 0 || matrix[stepY][stepX] > 0) {
                int tmp = dx;
                dx = -1 * dy;
                dy = tmp;
            }

            x += dx;
            y += dy;
        }

        return matrix;
    }
}
