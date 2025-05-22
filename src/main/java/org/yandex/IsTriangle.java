package org.yandex;

import java.io.*;

public class IsTriangle {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int a = readInt(reader);
            int b = readInt(reader);
            int c = readInt(reader);
            int max = Math.max(Math.max(a, b), c);
            if (isTriangle(a, b, c, max)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isTriangle(int a, int b, int c, int max) {
        if (a == max && a < (b + c)) {
            return true;
        } else if ( b == max && b < (a + c)) {
            return true;
        } else return c == max && c < (a + b);
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
