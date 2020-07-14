package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementT496 {

    // 时间复杂度为O(N^2)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int val = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (num == nums2[j]) {
                    while (j < nums2.length - 1) {
                        if (nums2[j + 1] > num) {
                            val = nums2[j + 1];
                            break;
                        }
                        j++;
                    }
                    break;
                }
            }
            nums1[i] = val;

        }
        return nums1;
    }

    // 参考 时间复杂度O(N)
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                numsMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numsMap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}