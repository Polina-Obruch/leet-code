package org.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 Подготовка к собеседованию в Яндекс - B
 */
public class ConsecutiveUnits {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int length = 0;
            int currentLength = 0;

            for (int i = 0; i < n; ++i) {
                int current = Integer.parseInt(reader.readLine());
                if (current != 1) {
                    currentLength = 0;
                } else {
                    ++currentLength;
                }

                length = Math.max(currentLength, length);
            }

            System.out.println(length);

        }
    }
}
