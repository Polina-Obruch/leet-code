package org.yandex;

import java.io.*;

public class SettingTags {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int count = Integer.parseInt(reader.readLine());
            System.out.println(getTime(count));

        }
    }

    private static int getTime(int count) {
        if ( count < 3) {
            return count;
        }

        int[] time = new int[count + 1];
        time[1] = 1;
        time[2] = 1;
        int result = 2;

        for (int i = 3; i <= count; ++i) {
            time[i] = time[i - 1] + time[i - 2];
            result += time[i];
        }

        return result;
    }
}
