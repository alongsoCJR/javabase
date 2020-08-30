package focus.javabase.com.algorithm.swordoffer;

import java.util.Stack;

public class ValidateStackSequencesO31 {

    // info
    //			Success:
    //			Runtime:2 ms, faster than 94.68% of Java online submissions.
    //			Memory Usage:39.6 MB, less than 19.31% of Java online submissions.
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            int target = popped[j];
            // 不等于弹出值，就弹入栈
            while (i < pushed.length && pushed[i] != target) {
                stack.push(pushed[i++]);
            }
            if (i >= pushed.length) {
                return false;
            }

            // 直到找到相等的弹入
            stack.push(pushed[i]);
            // 比较val值，将相同的弹出
            while (!stack.isEmpty() && target == stack.peek()) {
                stack.pop();
                if (j < popped.length - 1) {
                    target = popped[++j];
                }
            }
            // 自增，遍历第一个序列
            i++;
        }
        return stack.isEmpty();
    }

    // 优化target   效率反而降低了
    //info
    //			Success:
    //			Runtime:3 ms, faster than 76.06% of Java online submissions.
    //			Memory Usage:39.3 MB, less than 71.29% of Java online submissions.
    public static boolean validateStackSequences0(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            // 不等于弹出值，就弹入栈
            while (i < pushed.length && pushed[i] != popped[j]) {
                stack.push(pushed[i++]);
            }
            if (i >= pushed.length) {
                return false;
            }

            // 直到找到相等的弹入
            stack.push(pushed[i]);
            // 比较val值，将相同的弹出
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            // 自增，遍历第一个序列
            i++;
        }
        return stack.isEmpty();
    }

    // 参考 贪心
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }

}