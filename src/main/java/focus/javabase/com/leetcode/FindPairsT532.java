package focus.javabase.com.leetcode;

import java.util.*;

public class FindPairsT532 {

    // 暴力法  {1, 1, 1, 2, 1} [1，2，1]->1、[3,1,5]->2  这种方式不好处理这个特殊情况
    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isPostive = false;
            boolean isNegative = false;
            for (int j = i + 1; j < nums.length; j++) {
                int subScale = nums[i] - nums[j];
                if (subScale == k && k == 0) {
                    count++;
                    break;
                }
                if (subScale == k && !isPostive) {
                    count++;
                    isPostive = true;
                }
                if (subScale == -k && !isNegative) {
                    count++;
                    isNegative = true;
                }
            }
        }
        return count;
    }


    // 暴力法 处理重复(i,j)、(j,i)问题
    public static int findPairs1(int[] nums, int k) {
        if (k < 0) return 0;
        // 排序，避免Map覆盖的问题
        Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], nums[j]);
                        map.put(nums[j], nums[i]);
                        count++;
                    } else {
                        if (map.get(nums[i]) != nums[j]) {
                            map.put(nums[i], nums[j]);
                            map.put(nums[j], nums[i]);
                            count++;
                        }
                    }
                }
            }

        }
        return count;
    }

    // 暴力法优化 时间复杂度O(N^2) 空间复杂度O(N)
    public static int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;
        // 排序，避免Map覆盖的问题
        Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果有直接跳过
            if (map.containsKey(nums[i])) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], nums[j]);
                        count++;
                    }
                }
            }

        }
        return count;
    }


    // 参考
    public static int findPairs3(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (k == 0 && value > 1) {
                count++;
            } else if (k != 0 && map.containsKey(key - k)) {
                count++;
            }
        }
        return count;
    }


    // 参考
    public int findPairs4(int[] nums, int k) {
        if (k < 0)
            return 0;
        Arrays.sort(nums);
        int start = 0, count = 0, prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) {
                    i--;
                }
            } else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }
}