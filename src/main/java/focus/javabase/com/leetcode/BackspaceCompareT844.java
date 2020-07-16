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

    public static boolean backspaceCompare2(String S, String T) {
        int count = 0;
        char c = ' ';
        String s = "";
        String t = "";
        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if ('#' == c) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    s = c + s;
                }
            }
        }

        count = 0;
        for (int i = T.length() - 1; i >= 0; i--) {
            c = T.charAt(i);
            if ('#' == c) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    t = c + t;
                }
            }
        }

        return s.equals(t);
    }

    //参考 双指针
    public static boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;

    }


}