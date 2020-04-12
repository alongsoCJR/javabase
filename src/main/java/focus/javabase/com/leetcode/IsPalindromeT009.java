package focus.javabase.com.leetcode;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学

/**
 * @author chenjianrong-lhq 2019年08月03日 17:04:48
 * @Description: 是否是回文数
 * @ClassName: IsPalindromeT009
 */
public class IsPalindromeT009 {

    /**
     * @return boolean
     * @Author chenjianrong-lhq
     * @Description 你能不将整数转为字符串来解决这个问题吗？
     * @Date 2019-08-03 17:16
     * @Param [x]
     **/
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = (x + "").toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 将整数反转, 判断反转之后的值是否相等
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int num = x;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                rev = 0;
            }
            if (rev < (Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                rev = 0;
            }
            rev = rev * 10 + pop;
        }
        return rev == num;
    }

}
