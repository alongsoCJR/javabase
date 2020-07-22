package focus.javabase.com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindowT239 {

    // 暴力法
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        int result[] = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = (max > nums[i + j] ? max : nums[i + j]);
                result[i] = max;
            }
        }
        return result;
    }

    // 参考 1, 3, -1, -3, 5, 3, 6, 7
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        int result[] = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1 && queue.peek() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);

            if (i >= k - 1) {
                result[i - k + 1] = queue.peek();
            }
        }
        return result;
    }
}