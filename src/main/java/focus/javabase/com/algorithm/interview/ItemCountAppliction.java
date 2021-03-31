package focus.javabase.com.algorithm.interview;

import java.util.*;

/**
 * @Author alongso.cjr
 * @Description mt TOPK问题
 * @Date 2021-03-31 20:44
 **/
public class ItemCountAppliction {


    public static Set<ItemCount> getSortedResult(String[] strs) {
        if (strs == null || strs.length == 1) {
            return null;
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : strs) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        ItemCount itemCount;
        Set<ItemCount> countSet = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            itemCount = new ItemCount(entry.getKey(), entry.getValue());
            countSet.add(itemCount);
        }
        return countSet;
    }

    static class ItemCount implements Comparable {
        String item;
        Integer count;

        public ItemCount(String item, Integer count) {
            this.item = item;
            this.count = count;
        }


        // 重写排序的方法
        @Override
        public int compareTo(Object o) {
            ItemCount other = (ItemCount) o;
            if (this.count > other.count) {
                return -1;
            } else if (this.count.equals(other.count)) {
                return this.item.compareTo(other.item);
            } else {
                return 1;
            }
        }
    }

}