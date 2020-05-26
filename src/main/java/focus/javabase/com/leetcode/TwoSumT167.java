package focus.javabase.com.leetcode;


import java.util.HashMap;
import java.util.Map;

public class TwoSumT167 {


    //{2, 7, 11, 15}  {7,2,-2,-6}
    // 没有利用有序这个条件  时间复杂度（O(n)）
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numMap.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numMap.containsKey(numbers[i])) {
                int j = numMap.get(numbers[i]);
                if (i > j) {
                    return new int[]{j + 1, i + 1};
                } else {
                    return new int[]{i + 1, j + 1};

                }
            }
        }
        return null;
    }

    // {2, 7, 11, 15}  时间复杂度（O(nlogn)）
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = findByOrder(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (j > 0) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    private static int findByOrder(int[] numbers, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                return findByOrder(numbers, target, mid + 1, right);
            } else {
                return findByOrder(numbers, target, left, mid - 1);
            }
        }
        return -1;
    }


    // 参考     {2, 7, 11, 15}
    public static int[] twoSum2(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (target < sum) {
                right--;
            } else if (target > sum) {
                left++;
            }
        }
        return null;
    }

}