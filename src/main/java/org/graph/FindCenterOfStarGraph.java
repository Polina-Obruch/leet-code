package org.graph;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> countPick = new HashMap<>();
        //Сколько строк в массиве
        int size = edges.length;

        for (int i = 0; i < size; ++i) {
            int[] picks = edges[i];
            countPick.merge(picks[0], 1, Integer::sum);
            countPick.merge(picks[1], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> pick : countPick.entrySet()) {
            if (pick.getValue() == size - 1) {
                return pick.getKey();
            }
        }
        return -1;
    }
//    public int findCenter(int[][] edges) {
//        int[] firstEdge = edges[0];
//        int[] secondEdge = edges[1];
//
//        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
//                ? firstEdge[0]
//                : firstEdge[1];
//    }
}
