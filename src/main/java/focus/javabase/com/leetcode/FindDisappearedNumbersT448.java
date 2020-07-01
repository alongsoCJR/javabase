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