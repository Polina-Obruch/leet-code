package org.yandex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; ++i) {
            map.merge(nums1[i], 1, (o, n) -> o + 1);
        }

        for (int i = 0; i < nums2.length; ++i) {
            Integer current = map.get(nums2[i]);
            if (current != null) {
                if (current > 1) {
                    map.put(nums2[i], --current);
                } else {
                    map.remove(nums2[i]);
                }
                result.add(nums2[i]);
            }

        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }

        return res;
    }
}
