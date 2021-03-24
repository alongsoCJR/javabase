package focus.javabase.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesT228 {


    public static List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            while (i < (nums.length - 1) && (nums[i] + 1) == nums[i + 1]) {
                i++;
            }
            if (start == nums[i]) {
                result.add(start + "");
            } else {
                result.add(start + "->" + nums[i]);
            }
        }
        return result;
    }

    // 优化一下取区间的函数
    public static List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            while (i < (nums.length - 1) && (nums[i] + 1) == nums[i + 1]) {
                i++;
            }
            result.add(getRange(start, nums[i]));

        }
        return result;
    }

    // 字符拼接优化
    private static String getRange(int start, int to) {
        StringBuilder sb = new StringBuilder();
        return to > start ? sb.append(start).append("->").append(to).toString() : sb.append(start).toString();
    }
}