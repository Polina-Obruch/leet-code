package org.prefix_sum;

import java.io.*;

public class MaximumScoreAfterSplittingString {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = reader.readLine();
            System.out.println(maxScore(line));
        }
    }

    static public int maxScore(String s) {
        int size = s.length();
        int[] countZero = new int[size + 1];
        int[] countOne = new int[size + 1];
        int score = 0;
        for (int i = 0; i < size; ++i) {
            if (s.charAt(i) == '0') {
                countZero[i + 1] = countZero[i] + 1;
                //Не забывать обновлять данные иначе предыдущее будет ноль
                countOne[i + 1] = countOne[i];
            } else {
                countOne[i + 1] = countOne[i] + 1;
                countZero[i + 1] = countZero[i];
            }
        }

        //Не проходим последний элемент так как это вся строка, а нее разбиение
        for (int i = 1; i < size; ++i) {
            score = Math.max(score, countZero[i] + (countOne[size] - countOne[i]));
        }
        return score;
    }
}
/**
 * class Solution {
 *     public int maxScore(String s) {
 *         int ones = 0;
 *         int zeros = 0;
 *         int best = Integer.MIN_VALUE;
 *
 *         for (int i = 0; i < s.length() - 1; i++) {
 *             if (s.charAt(i) == '1') {
 *                 ones++;
 *             } else {
 *                 zeros++;
 *             }
 *
 * // Недостоющие единицы добавятся в конце
 *             best = Math.max(best, zeros - ones);
 *         }
 *
 *         if (s.charAt(s.length() - 1) == '1') {
 *             ones++;
 *         }
 *
 * //Добавляется недостоющее количество единиц
 *         return best + ones;
 *     }
 * }

 */
