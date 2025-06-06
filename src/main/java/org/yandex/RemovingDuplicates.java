package org.yandex;

import java.io.*;
import java.util.Objects;

/**
 Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.
 Желательно получить решение, которое не считывает входной файл целиком в память,
 т.е., использует лишь константный объем памяти в процессе работы.
 Подготовка к собеседованию в Яндекс - C
 */

//Не проходило по времени при переводе строк в числа.
public class RemovingDuplicates {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine());
            String previous = " ";

            while (n > 0) {
                String current = reader.readLine();
                if (!Objects.equals(current, previous)) {
                    writer.write(current);
                    writer.write('\n');
                    previous = current;
                }
                --n;
            }
        }
    }
}
