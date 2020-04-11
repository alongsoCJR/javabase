package focus.javabase.com.leetcode;


/*

给定一个整数数组 nums 和一个目标值 target
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  示例:
  给定 nums = [2, 7, 11, 15], target = 9
  因为 nums[0] + nums[1] = 2 + 7 = 9
  所以返回 [0, 1]
*/

import java.util.*;

/**
 * @author chenjianrong-lhq 2019年07月11日 12:53:33
 * @Description:
 * @ClassName: TwoNumAddT001
 */
public class TwoNumAddT001 {

    /**
     * 时间复杂度为O(n^2)
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] index = {};
        for (int i = 0; i < nums.length; i++) {
            int firstValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (firstValue + nums[j] == target) {
                    index = new int[]{i, j};
                    break;
                }
            }
        }
        return index;
    }


    /**
     * [2, 7, 1, 11, 15] -> [15 ,10 ,2 ,6 , 2] 时间复杂度O(n)
     **/
    private static int[] twoSum1(int[] nums, int target) {
        int[] index = {};
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(target - nums[i])) {
                numsMap.put(nums[i], i);
            } else {
                int otherIndex = numsMap.get(target - nums[i]);
                index = new int[]{otherIndex, i};
            }
        }
        return index;
    }


    public static int[] twoSum2(int[] nums, int target) throws Exception {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        throw new Exception("未找到两数之和为目标数值的下标");
    }

    /**
     * 时间复杂度为O(n)
     **/
    public static int[] twoSum3(int[] nums, int target) throws Exception {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int destNum = target - nums[i];
            if (numsMap.containsKey(destNum) && (numsMap.get(destNum) != i)) {
                return new int[]{(numsMap.get(destNum)), i};
            }
        }
        throw new Exception("未找到两数之和为目标数值的下标");
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{3, 3};
        int[] index = twoSum2(nums, 6);
        System.out.println(Arrays.toString(index));
    }
}
