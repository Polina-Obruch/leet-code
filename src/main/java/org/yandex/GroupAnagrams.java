package org.yandex;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        //groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] chars = new int[26];

            for (char c : s.toCharArray()) {
                chars[c - 'a'] = chars[c - 'a'] + 1 ;
            }

            StringBuilder builder = new StringBuilder();
            for (int aChar : chars) {
                builder.append(aChar).append("*");
            }

            List<String> group = map.get(builder.toString());

            if (group == null) {
                group = new ArrayList<>();
            }

            group.add(s);
            map.put(builder.toString(), group);

        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> group = map.get(key);

            if (group == null) {
                group = new ArrayList<>();
            }

            group.add(s);
            map.put(key, group);

        }

        return new ArrayList<>(map.values());
    }


}
