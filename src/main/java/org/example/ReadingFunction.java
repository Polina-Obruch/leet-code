package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingFunction {
    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static <T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                    try {
                        writer.write(String.valueOf(elem));
                        writer.write(" ");
                    } catch (IOException e) {

                    }
                }
        );
    }

    /**Считывание пары чисел без сплит**/
//    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//    int value_1 = Integer.parseInt(tokenizer.nextToken());
//    int value_2 = Integer.parseInt(tokenizer.nextToken());
}
