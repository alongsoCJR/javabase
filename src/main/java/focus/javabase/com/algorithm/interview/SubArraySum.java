package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @Author chenjianrong-lhq
 * @Description mt机试
 * @Date 2020-09-21 11:24
 **/
public class SubArraySum {


    // 暴力法 连续的子数组
    public static List<List<Integer>> subarraySum0(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
        List<Integer> numList = null;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            numList = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum < k) {
                    numList.add(nums[j]);
                } else if (sum == k) {
                    numList.add(nums[j]);
                    List<Integer> list = new ArrayList<>(numList);
                    result.add(list);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> subarraySum(int[] nums, int target) {
        List<List<Integer>> outputArrayList = Combination.combinationWithArray(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> list : outputArrayList) {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            if (sum == target) {
                result.add(list);
            }
        }
        return result;
    }

    public static List<List<Integer>> combinationWithArray(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int num = 1; num <= nums.length; num++) {
            combinationByRecursion(nums, num, result, 0, nums.length - 1);
        }
        return result;
    }

    private static void combinationByRecursion(int[] nums, int num, List<List<Integer>> result, int left, int right) {
        if (num == 1) {
            for (int i = left; i < nums.length; i++) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                result.add(list);
            }
            return;
        }

        if (right - left + 1 == num) {
            List<Integer> list = new LinkedList<>();
            for (int i = left; i <= right; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }

        if (right - left + 1 > num) {
            // 不包含
            combinationByRecursion(nums, num, result, left + 1, right);

            // 包含
            List<List<Integer>> subList = new LinkedList<>();
            combinationByRecursion(nums, num - 1, subList, left + 1, right);
            for (List<Integer> list : subList) {
                list.add(nums[left]);
                result.add(list);
            }
        }

    }
}