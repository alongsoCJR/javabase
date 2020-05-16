package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumberT136 {

    // map.put(key,val++)  先put 再加加
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int val = countMap.get(num);
                countMap.put(num, ++val);
            } else {
                countMap.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }
        System.out.println("Don't exist singleNumber!");
        return Integer.MIN_VALUE;
    }

    // 位运算定律：a^0=a、b^b=0、a^(b^b)=(a^b)^b=a
    public static int singleNumber1(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}