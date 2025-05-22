package org.yandex;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThanYourNeighbors {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            List<Integer> numbers = readList(reader);
            int result = 0;

            for (int i = 1; i < numbers.size() - 1; ++i) {
                if (numbers.get(i - 1) < numbers.get(i) && numbers.get(i) > numbers.get(i + 1)) {
                    ++result;
                    ++i;
                }
            }
            System.out.println(result);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
