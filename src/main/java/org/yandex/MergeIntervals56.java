package org.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int m = 2;
        int[] prev = intervals[0];


        for (int i = 1; i < n; ++i) {
            int[] cur = intervals[i];

            if (cur[0] <= prev[1] ) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                res.add(prev);
                prev = cur;
            }

        }

        res.add(prev);
        /*int[][] ans = new int[res.size()][2];

        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }*/

        return res.toArray(new int[res.size()][]);

    }
}
