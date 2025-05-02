package org.prefix_sum;

import java.io.*;

public class MinimumAmountOfTimeToCollectGarbage {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] garbage = reader.readLine().split(" ");
            String[] travelLine = reader.readLine().split(" ");
            int[] travel = new int[travelLine.length];
            for (int i = 0; i < travel.length; ++i) {
                travel[i] = Integer.parseInt(travelLine[i]);
            }
            System.out.println(garbageCollection(garbage, travel));
        }
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int indexM = 0;
        int indexG = 0;
        int indexP = 0;
        int commonTime = 0;

        int[] prefixTime = new int[travel.length + 1];

        for (int i = 1; i < prefixTime.length; ++i) {
            prefixTime[i] = prefixTime[i - 1] + travel [i - 1];
        }

        for (int i = 0; i < garbage.length; ++i) {
            String currentLine = garbage[i];
            commonTime += currentLine.length();
            boolean isM = false;
            boolean isP = false;
            boolean isG = false;

            //Поиск индекса дома, где в последний раз был определенный тип мусора
            for (int j = 0; j < currentLine.length(); ++j) {
                char currentChar = currentLine.charAt(j);

                if (currentChar == 'M') {
                    indexM = i;
                    isM = true;
                } else if (currentChar == 'P') {
                    indexP = i;
                    isP = true;
                } else if (currentChar == 'G') {
                    indexG = i;
                    isG = true;
                }

                if (isM && isP && isG) {
                    break;
                }
            }
        }
        return commonTime +  prefixTime[indexM] + prefixTime[indexP] + prefixTime[indexG];

    }
}
