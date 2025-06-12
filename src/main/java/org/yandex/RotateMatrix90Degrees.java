package org.yandex;

import java.io.*;

public class RotateMatrix90Degrees {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7,  8, 9}});
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //Меняем строчки - зеркалим относительно середины
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < m; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        //Транспонируем матрицу
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < m; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
