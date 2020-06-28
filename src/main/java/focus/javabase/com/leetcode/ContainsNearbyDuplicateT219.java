package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicateT219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(i, nums[i]);
        }

        // 暴力遍历
        Set<Map.Entry<Integer, Integer>> entrySet = numsMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int value = entry.getValue();
            int key = entry.getKey();
            for (int i = key + 1; i < nums.length; i++) {
                if (value == nums[i] && (i - key) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        // 暴力遍历
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int key = i;
            for (int j = key + 1; j < nums.length; j++) {
                if (value == nums[j] && (j - key) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    // 散列表
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // 滑动窗口
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // 参考
    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}