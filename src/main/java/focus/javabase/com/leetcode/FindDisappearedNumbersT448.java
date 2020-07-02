package focus.javabase.com.leetcode;

import java.util.*;

public class FindDisappearedNumbersT448 {


    // 空间复杂度 O(n) 时间复杂度 O(n)
    // Success:
    //			Runtime:33 ms, faster than 5.07% of Java online submissions.
    //			Memory Usage:50.1 MB, less than 33.33% of Java online submissions.
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        List<Integer> retList = new ArrayList<>(set);
        return retList;
    }


    // 优化，去重 下标和元素映射
    // Success:
    //			Runtime:301 ms, faster than 5.07% of Java online submissions.
    //			Memory Usage:48.4 MB, less than 66.67% of Java online submissions.
    //
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> retList = new ArrayList<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            retList.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            retList.set(nums[i] - 1, null);
        }

        Iterator iterator = retList.iterator();
        while (iterator.hasNext()) {
            Integer val = (Integer) iterator.next();
            if (val == null) {
                iterator.remove();
            }
        }
        return retList;
    }


    // 4, 3, 2, 7, 8, 2, 3, 1
    // 1, 2, 3, 4, 5, 6, 7, 8
    // 参考
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        // 置负数
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                retList.add(i + 1);
            }
        }

        return retList;
    }

    // 参考 优化，更容易理解
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        // 置负数
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * (nums[index]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                retList.add(i + 1);
            }
        }

        return retList;
    }


    // 参考  抽屉原理 + 基于“异或运算”交换两个变量的值
    public static List<Integer> findDisappearedNumbers4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }


    public List<Integer> findDisappearedNumbers5(int[] nums) {
        int n = nums.length;
        boolean[] map = new boolean[n + 1];
        for (int x : nums) {
            map[x] = true;
        }

        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (!map[i]) {
                list.add(i);
            }
        }

        return list;
    }
    // for (int i = 1; i <= nums.length; i++) {
    //            retList.add(i);
    //        }
    //
    //        for (int i = 0; i < nums.length; i++) {
    //            if (retList.contains(nums[i])) {
    //                retList.remove(nums[i]);
    //            }
    //        }
}