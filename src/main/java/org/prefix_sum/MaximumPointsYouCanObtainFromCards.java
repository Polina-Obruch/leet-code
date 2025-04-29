package org.prefix_sum;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Карточки набираются на итоговый максимум. Поэтому сравнение двух значений конца-начало не имеет смысла.
 * Считаю префиксную сумму, а потом рассматриваю все возможные комбинации. Например:
 * к = 4: 4 + 0, 3 + 1, 2 + 2, 1 + 3, 0 + 4 - количество элементов от начала / конца
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int k = readInt(reader);
            String[] line = reader.readLine().split(",");
            int[] cardPoints = new int[line.length];
            for (int i = 0; i < line.length; ++i) {
                cardPoints[i] = Integer.parseInt(line[i]);
            }

            System.out.println(maxScore(cardPoints, k));

        }
    }

    public static int maxScore(int[] cardPoints, int k) {
        int size = cardPoints.length;
        int score = 0;
        int[] prefixSum = new int[size + 1];

        for (int i = 0; i < size; ++i) {
            prefixSum[i + 1] = prefixSum[i] + cardPoints[i];
        }

        for (int i = 0; i <= k; ++i) {
            score = Math.max(score, prefixSum[i] + (prefixSum[size] - prefixSum[size - (k - i)]));
        }

        return score;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
