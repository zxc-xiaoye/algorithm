package com.company.greedy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiaoye
 * @create 2020-08-26 21:43
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>(5);

        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        broadcasts.put("K1", set1);

        HashSet<String> set2 = new HashSet<>();
        set2.add("北京");
        set2.add("广州");
        set2.add("深圳");
        broadcasts.put("K2", set2);

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        broadcasts.put("K3", set3);

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        broadcasts.put("K4", set4);


        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        broadcasts.put("K5", set5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("广州");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> tmpSet = new HashSet<>();

        String maxKey;
        while (!allAreas.isEmpty()) {
            maxKey = null;

            for (String key : broadcasts.keySet()) {
                tmpSet.clear();

                tmpSet.addAll(broadcasts.get(key));
                tmpSet.retainAll(allAreas);

                if (tmpSet.size() > 0 &&
                        (maxKey == null || tmpSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);
    }
}
