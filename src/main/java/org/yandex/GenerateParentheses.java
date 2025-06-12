package org.yandex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            List<String> result = generateParenthesis(3);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getString(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public static void getString(int n, int countOpen, int countClose, StringBuilder builder, List<String> result) {
        if (builder.length() == n * 2 && countOpen == countClose) {
            result.add(builder.toString());
            return;
        }

        if (countOpen < n) {
            getString(n, countOpen + 1, countClose, builder.append("("), result);
            builder.deleteCharAt(builder.length() - 1);
        }

        //Условие чтобы не было скобочных последовательностей начинающихся с ")"
        if (countClose < countOpen) {
            getString(n, countOpen, countClose + 1, builder.append(")"), result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
