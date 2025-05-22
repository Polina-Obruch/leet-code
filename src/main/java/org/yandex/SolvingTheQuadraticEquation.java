package org.yandex;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class SolvingTheQuadraticEquation {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            double a = Double.parseDouble(tokenizer.nextToken());
            double b = Double.parseDouble(tokenizer.nextToken());
            double c = Double.parseDouble(tokenizer.nextToken());

            System.out.println(getSolving(a,b,c));

        }
    }

    private static String getSolving(double a, double b, double c) {
         double discriminant = b * b - 4 * a * c;

         if (discriminant == 0) {
             System.out.println(1);
             BigDecimal result = BigDecimal.valueOf(((-1 * b) / (2 * a))).setScale(6, RoundingMode.HALF_UP);
             return String.valueOf(result);
         } else if (discriminant < 0) {
             return "0";
         } else {
             System.out.println(2);
             BigDecimal one = BigDecimal.valueOf((((-1 * b) + Math.sqrt(discriminant)) / (2 * a))).setScale(6, RoundingMode.HALF_UP);
             BigDecimal two = BigDecimal.valueOf((((-1 * b) - Math.sqrt(discriminant)) / (2 * a))).setScale(6, RoundingMode.HALF_UP);

             if (one.compareTo(two) > 0) {
                 return String.valueOf(two) + " " + String.valueOf(one);
             } else {
                 return String.valueOf(one) + " " + String.valueOf(two);
             }
         }
    }
}
