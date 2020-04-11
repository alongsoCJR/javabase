package focus.javabase.com.leetcode;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，qing返回 INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class AStringToIntT008 {

    public static int myAtoi(String str) {
        str = str.replaceAll("[+]", "");
        if (str.length() > 11) {
            str = str.substring(0, 11);
        }
        /**step1:将String字符串转化按照" "分段**/
        String[] strArray = str.split(" ");
        Long num = 0L;
        for (String strNum : strArray) {
            /**如果开头时字符是非""和"+ -"，那么返回0**/
            if (!"".equals(strNum)) {
                /**这里需要用到正则表达式**/
                if (!isMatch(strNum)) {
                    /**这里适合用递归啊**/
                    if (isMatch(strNum.substring(0, 1))) {
                        for (int i = 1; i < strNum.length(); i++) {
                            if (!Character.isDigit(strNum.charAt(i))) {
                                num = Long.parseLong(strNum.substring(0, i));
                                break;
                            }
                        }
                    } else {
                        return 0;
                    }
                } else {
                    /**step2:将String类型转化为int类型**/
                    num = Long.parseLong(strNum);
                }
                break;
            }
        }
        num = num > Integer.MAX_VALUE ? Integer.MAX_VALUE : num;
        num = num < Integer.MIN_VALUE ? Integer.MIN_VALUE : num;
        return num.intValue();
    }

    public static int myAtoi1(String str) {
        /** 处理空格**/
        BigInteger targetNum = new BigInteger("0");
        boolean flag = true;
        StringBuilder targetStr = new StringBuilder(11);
        for (int i = 0; i < str.length(); i++) {
            char indexChar = str.charAt(i);
            if ((indexChar == '+' || indexChar == '-') && flag) {
                targetStr.append(indexChar);
                flag = false;
                continue;
            }
            if (indexChar == ' ' && flag) {
                continue;
            }
            if (Character.isDigit(indexChar)) {
                targetStr.append(indexChar);
                flag = false;
            } else {
                break;
            }
        }
        if (!"".equals(targetStr.toString()) && isMatch(targetStr.toString())) {
            /**这里如何处理Long类型越界的问题？**/
            try {
                targetNum = new BigInteger(targetStr.toString());
            } catch (Exception e) {
                return 0;
            }
            /**做的一个小小的优化，利用BigInteger源码,max与min方法**/
            targetNum = targetNum.min(BigInteger.valueOf(Integer.MAX_VALUE)).max(BigInteger.valueOf(Integer.MIN_VALUE));
//            targetNum = targetNum.compareTo(new BigInteger("2147483647")) > 0 ? new BigInteger("2147483647") : targetNum;
//            targetNum = targetNum.compareTo(new BigInteger("-2147483648")) < 0 ? new BigInteger("-2147483648") : targetNum;
        }
        return targetNum.intValue();
    }


    /**
     * @return boolean
     * @Author chenjianrong-lhq
     * @Description 匹配字符串中是否只包含+，-号以及0至9的字符
     * @Date 2019-07-22 09:32
     * @Param [strNum]
     **/
    private static boolean isMatch(String strNum) {
//        Pattern pattern = Pattern.compile("[0-9\\-\\+]+");
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(strNum).matches();
    }


    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description leetcode上问题python的解法
     * todo:1.利用正则表达式一步到位   2.避免整数过大溢出的问题
     * <p>
     * todo  java版非正则表达式的实现
     * @Date 2019-07-22 11:00
     * @Param [str]
     **/
    public static int myAtoi2(String str) {
        /**处理首位**/
        int i = 0, j = 0, len = str.length();
        boolean nagtive = false;
        for (i = 0; i < len; i++) {
            char indexChar = str.charAt(i);
            if (indexChar >= '0' && indexChar <= '9') {
                break;
            } else if (indexChar == '+' || indexChar == '-') {
                nagtive = indexChar == '-';
                i++;
                break;
            } else if (indexChar != ' ') {
                return 0;
            }
        }

        for (j = i; j < len; j++) {
            char indexChar = str.charAt(j);
            if (indexChar < '0' || indexChar > '9') {
                break;
            }
        }
        /**提取出中间体数字字符**/
        String numStr = str.substring(i, j);
        int result = 0;
        /**整数溢出的处理**/
        for (int m = 0; m < numStr.length(); m++) {
            /**char类型的数值转int类型**/
            int pop = numStr.charAt(m) - '0';
            if (nagtive) {
                if (result < (Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && pop > 8)) {
                    return Integer.MIN_VALUE;
                }
                result = 10 * result - pop;
            } else {
                if (result > (Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return Integer.MAX_VALUE;
                }
                result = 10 * result + pop;
            }
        }
        return result;
    }
}


