package focus.javabase.com.leetcode;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

import java.util.ArrayDeque;

public class SignIsValidT020 {

    // deque中 poll方法能返回空，而使用pop会抛异常
    public static boolean isValid(String s) {
        assert s != null;
        if (s.length() == 0) {
            return true;
        }

        // 判断奇数 (s.length() & 1) == 1
        if ((s.length() & 1) == 1) {
            return false;
        }
        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deque.push(')');
            } else if (c == '{') {
                deque.push('}');
            } else if (c == '[') {
                deque.push(']');
            }

            if (c == ')' || c == ']' || c == '}') {
                Character c1 = deque.poll();
                if (c1 == null || c != c1) {
                    return false;
                }
                flag = true;
//                // {{)}
//                if (!flag) {
//                    return flag;
//                }
            }
        }
        // ([]
        return flag && deque.isEmpty();
    }




    /**
     * @Author chenjianrong-lhq
     * @Description 1.优化非空判断
     *              2.增加奇偶判断
     *              3.去除flag标识
     * @Date 2020-04-10 09:40
     * @Param [arg]
     * @return char
     **/
//        return deque1.isEmpty() && deque2.isEmpty() && deque3.isEmpty();
//    for (int i = 0; i < s.length(); i++) {
//        char c = s.charAt(i);
//        if (c == '(') {
//            deque1.push(')');
//        } else if (c == '{') {
//            deque2.push('}');
//        } else if (c == '[') {
//            deque3.push(']');
//        }
//
//        if (c == ')') {
//            flag = (c == dealNull(deque1.poll()));
//        } else if (c == '}') {
//            flag = (c == dealNull(deque2.poll()));
//        } else if (c == ']') {
//            flag = (c == dealNull(deque3.poll()));
//        }
//    }

    public static char dealNull(Character arg) {
        if (arg == null) {
            return ' ';
        }
        return arg;
    }
}

