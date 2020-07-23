package focus.javabase.com.leetcode;

import java.util.Stack;

public class RemoveOuterParentheses {

    private static char[] cs = new char[]{'(', ')'};

    public static String removeouterparentheses(String S) {
        int opened = 0;
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == cs[0]) {
                opened++;
                if (opened > 1) {
                    sbd.append(S.charAt(i));
                }
            } else {
                opened--;
                if (opened > 0) {
                    sbd.append(S.charAt(i));
                }
            }
        }
        return sbd.toString();
    }


    // (()())(())(()(()))  (()())(())
    public static String removeouterparentheses1(String S) {
        Stack<Character> stack = new Stack();
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == cs[0]) {
                stack.push(S.charAt(i));
                if (stack.size() > 1) {
                    result += cs[0];
                }
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    result += cs[1];
                }
            }
        }
        return result;
    }

    // 参考
    public String removeOuterParentheses2(String S) {
        StringBuilder sbd = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --count;
            if (count > 0) sbd.append(c);
            if (c == '(') ++count;
        }
        return sbd.toString();
    }
}