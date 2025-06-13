package org.TopInterview;

import java.util.ArrayList;
import java.util.List;

/** Дан отсортированный массив. Нужно собрать все возможные интервалы.
 * [0,1,2,4,5,7] -> ["0->2","4->5","7"];
 * **/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> interval = new ArrayList<>();
        String defis = "->";

        for (int i = 0; i < nums.length; ++i) {
            int start = nums[i];
            StringBuilder builder = new StringBuilder();

            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                ++i;
            }

            if (start == nums[i]) {
                interval.add(builder.append(start).toString());
            } else {
                interval.add(builder.append(start).append(defis).append(nums[i]).toString());
            }
        }
        return interval;
    }
}
