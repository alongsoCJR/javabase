package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElementT169 {


    // 执行用时 :17 ms, 在所有 Java 提交中击败了27.93%的用户
    // 内存消耗 :44.7 MB, 在所有 Java 提交中击败了5.71%的用户
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                countMap.put(num, count + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 参考
    public static int majorityElement1(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}