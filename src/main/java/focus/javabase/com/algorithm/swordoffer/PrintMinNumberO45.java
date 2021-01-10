package focus.javabase.com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.List;

public class PrintMinNumberO45 {

    public static int printMinNumber(int[] nums) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        List<List<Integer>> allNumberStrings = new ArrayList<>();
        getAllNumberStrings(nums, allNumberStrings, 0);
        int minNumber = Integer.MAX_VALUE;
        for (List<Integer> numberList : allNumberStrings) {
            StringBuilder sb = new StringBuilder();
            for (int number : numberList) {
                sb.append(number);
            }
            minNumber = Math.min(minNumber, Integer.valueOf(sb.toString()));
        }
        return minNumber;
    }

    private static void getAllNumberStrings(int[] numbers, List<List<Integer>> allNumberStrings, int index) {
        if (index == numbers.length - 1) {
            List<Integer> list = new ArrayList<>();
            list.add(numbers[index]);
            allNumberStrings.add(list);
            return;
        }
        List<List<Integer>> subResult = new ArrayList<>();
        getAllNumberStrings(numbers, subResult, index + 1);
        int curNum = numbers[index];
        for (List<Integer> integers : subResult) {
            for (int i = 0; i <= integers.size(); i++) {
                List<Integer> result = new ArrayList<>();
                result.addAll(integers);
                result.add(i, curNum);
                allNumberStrings.add(result);
            }
        }
    }
}