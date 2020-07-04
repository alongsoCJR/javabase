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
}