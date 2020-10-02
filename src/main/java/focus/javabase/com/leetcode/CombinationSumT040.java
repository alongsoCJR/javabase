package focus.javabase.com.leetcode;

import focus.javabase.com.algorithm.interview.Combination;

import java.util.*;

public class CombinationSumT040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 对数组重复元素去重
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : candidates) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] array = new int[map.size()];
        int index = 0;
        for (int num : map.keySet()) {
            array[index++] = num;
        }

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(array, target, result, combine, 0);

        // 再处理重复的元素


        return result;
    }


    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            List<Integer> list = new LinkedList<>(combine);
            result.add(list);
            return;
        }
        // 不选择当前元素
        dfs(candidates, target, result, combine, index + 1);

        // 选择当前元素
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], result, combine, index + 1);
            if (index == candidates.length - 1 && target == candidates[index]) {
                result.add(new LinkedList<>(combine));
            }
            combine.remove(combine.size() - 1);
        }
    }

    // 组合时，区分重复的数字
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
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

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        // 对数组进行排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> combine = new ArrayList<>();
        dfs3(candidates, target, result, combine, 0);
        return result;
    }


    public void dfs3(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            List<Integer> list = new LinkedList<>(combine);
            result.add(list);
            return;
        }

        if (candidates[index] == candidates[index - 1]) {

        }
        // 不选择当前元素
        dfs3(candidates, target, result, combine, index + 1);

        // 选择当前元素
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs3(candidates, target - candidates[index], result, combine, index + 1);
            if (index == candidates.length - 1 && target == candidates[index]) {
                result.add(new LinkedList<>(combine));
            }
            combine.remove(combine.size() - 1);
        }
    }
}