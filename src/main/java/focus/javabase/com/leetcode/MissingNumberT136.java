package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MissingNumberT136 {

    //info
    //Success:
    //Runtime:9 ms, faster than 7.60% of Java online submissions.
    //Memory Usage:40.6 MB, less than 6.67% of Java online submissions.
    // 时间复杂度O(n) 空间复杂度 O(n)  优化 使用HashSet结构
    public static int missingNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], null);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!numMap.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    // 数学  等差数组 n项之和 n(a1+an)/2
    public static int missingNumber1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int exceptedSum = nums.length * (nums.length + 1) / 2;
        return exceptedSum - sum;
    }


    // 异或
    public static int missingNumber2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= (i ^ nums[i]);
        }
        num ^= nums.length;
        return num;
    }


    // 参考 优化
    public static int missingNumber3(int[] nums) {
        int num = nums.length;
        for (int i = 0; i < nums.length; i++) {
            num ^= (i ^ nums[i]);
        }
        return num;
    }


}