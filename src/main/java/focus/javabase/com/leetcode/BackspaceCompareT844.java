package focus.javabase.com.leetcode;

import java.util.Stack;

public class BackspaceCompareT844 {

    // 时间复杂度O(M+N)、空间复杂度O(M+N)
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        putCharIntoStack(s1, S);
        putCharIntoStack(s2, T);
        int size = s1.size();
        if (size == s2.size()) {
            while (size-- == 0) {
                if (!s1.pop().equals(s2.pop())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void putCharIntoStack(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            if ('#' == s.charAt(i)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
    }


    public static boolean backspaceCompare1(String S, String T) {
        String s1 = dealBackSpace(S);
        String s2 = dealBackSpace(T);
        return s1.equals(s2);
    }

    private static String dealBackSpace(String s) {
        String result = "";
        // toCharArray 维护了char[]
        for (char c : s.toCharArray()) {
            if ('#' == c) {
                if (result.length() != 0) {
                    // substring 维护了char[]
                    result = result.substring(0, result.length() - 1);
                }
            } else {
                result += c;
            }
        }
        return result;
    }
}