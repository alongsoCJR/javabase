package focus.javabase.com.algorithm.interview;

import java.util.*;

/**
 * @Author Jianrong.Chen
 * @Description 数值递增最长序列 3, 3, 4, 7, 5, 6 输出4
 * @Date 2022-10-12 15:43
 */
public class LongestLength {


    public static int getLongestLength(List<Integer> inputs) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            Integer item = inputs.get(i);
            if (countMap.containsKey(item - 1)) {
                countMap.put(item, countMap.getOrDefault(item - 1, 0) + 1);
            } else {
                countMap.put(item, 1);
            }
        }
        return Collections.max(countMap.values());
    }

    public static List<Integer> getLongestLength2(List<Integer> inputs) {
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            Integer item = inputs.get(i);
            indexMap.put(item, i);
            List<Integer> cur = new ArrayList<>();
            if (countMap.containsKey(item - 1)) {
                cur = new ArrayList<>(countMap.getOrDefault(item - 1, new ArrayList<>()));
            }
            cur.add(i);
            countMap.put(item, cur);
        }

        int max = 0;
        List<Integer> longestLengthList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : countMap.entrySet()) {
            if (max < entry.getValue().size()) {
                max = entry.getValue().size();
                longestLengthList = entry.getValue();
            }
        }
        return longestLengthList;
    }
}