package focus.javabase.com.algorithm.interview;


import java.util.LinkedList;
import java.util.List;

/**
 * @Author chenjianrong-lhq
 * @Description mt组合 机试题
 * @Date 2020-09-21 09:02
 **/
public class Combination {


    public static List<String> combination(String string) {
        List<String> result = new LinkedList<>();
        for (int num = 1; num <= string.length(); num++) {
            combinationByRecursion(string, num, result);
        }
        return result;
    }

    private static void combinationByRecursion(String string, int num, List<String> result) {
        if (num == 1) {
            for (char s : string.toCharArray()) {
                result.add(s + "");
            }
            return;
        }

        if (num == string.length()) {
            result.add(string);
        }

        if (string.length() > num) {
            // 不包含
            combinationByRecursion(string.substring(1), num, result);

            // 包含
            List<String> list = new LinkedList<>();
            combinationByRecursion(string.substring(1), num - 1, list);
            for (String s : list) {
                s += string.charAt(0);
                result.add(s);
            }
        }
    }

    public static List<List<Integer>> combinationForSum(int[] nums, int target) {
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
