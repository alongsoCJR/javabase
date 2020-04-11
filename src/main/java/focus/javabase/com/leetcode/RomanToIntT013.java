package focus.javabase.com.leetcode;

//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
// 示例 1:
//
// 输入: "III"
//输出: 3
//
// 示例 2:
//
// 输入: "IV"
//输出: 4
//
// 示例 3:
//
// 输入: "IX"
//输出: 9
//
// 示例 4:
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
// Related Topics 数学 字符串

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanToIntT013 {
    //I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 千
    public static final char ONE_FLAG = 'I';
    public static final char FIVE_FLAG = 'V';
    public static final char TEN_FLAG = 'X';
    public static final char FIFTY_FLAG = 'L';
    public static final char ONE_HUNDRED_FLAG = 'C';
    public static final char FIVE_HUNDRED_FLAG = 'D';
    public static final char ONE_THOUSAND_FLAG = 'M';

    public static int romanToInt(String s) {
        // 非空判断
        assert (s != null && !"".equals(s));
        int length = s.length();
//        int[] nums = new int[length];
        int sum = 0;
        char prevChar = ' ';
        for (int i = length - 1; i >= 0; i--) {
            char indexChar = s.charAt(i);
            int num = 0;
            if (ONE_FLAG == indexChar) {
                num = resolveRoman(indexChar);
                if (FIVE_FLAG == prevChar || TEN_FLAG == prevChar) {
                    num = -num;
                }
            } else if (FIVE_FLAG == indexChar) {
                num = resolveRoman(indexChar);
            } else if (TEN_FLAG == indexChar) {
                num = resolveRoman(indexChar);
                if (FIFTY_FLAG == prevChar || ONE_HUNDRED_FLAG == prevChar) {
                    num = -num;
                }
            } else if (FIFTY_FLAG == indexChar) {
                num = resolveRoman(indexChar);
            } else if (ONE_HUNDRED_FLAG == indexChar) {
                num = resolveRoman(indexChar);
                if (FIVE_HUNDRED_FLAG == prevChar || ONE_THOUSAND_FLAG == prevChar) {
                    num = -num;
                }
            } else if (FIVE_HUNDRED_FLAG == indexChar) {
                num = resolveRoman(indexChar);
            } else if (ONE_THOUSAND_FLAG == indexChar) {
                num = resolveRoman(indexChar);
            }
            sum += num;
            prevChar = indexChar;
        }

        return sum;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 找到对应的数值
     * @Date 2020-04-07 22:54
     * @Param [indexChar]
     **/
    private static int resolveRoman(char indexChar) {
        int num = 0;
        switch (indexChar) {
            case ONE_FLAG:
                num = 1;
                break;
            case FIVE_FLAG:
                num = 5;
                break;
            case TEN_FLAG:
                num = 10;
                break;
            case FIFTY_FLAG:
                num = 50;
                break;
            case ONE_HUNDRED_FLAG:
                num = 100;
                break;
            case FIVE_HUNDRED_FLAG:
                num = 500;
                break;
            case ONE_THOUSAND_FLAG:
                num = 1000;
                break;
        }
        return num;
    }

    public static Map<Character, Integer> flagMap = Collections.unmodifiableMap(new HashMap<Character, Integer>() {
        {
            put(ONE_FLAG, 1);
            put(FIVE_FLAG, 5);
            put(TEN_FLAG, 10);
            put(FIFTY_FLAG, 50);
            put(ONE_HUNDRED_FLAG, 100);
            put(FIVE_HUNDRED_FLAG, 500);
            put(ONE_THOUSAND_FLAG, 1000);
        }
    });

    public static int romanToIntByMap(String s) {
        // 非空判断
        assert (s != null && !"".equals(s));
        int sum = 0;
        if (s.length() == 1) {
            sum = flagMap.get(s.charAt(0));
        }
        for (int i = 0; i < s.length()-1; i++) {
            int prevNum = flagMap.get(s.charAt(i));
            int curNum = flagMap.get(s.charAt(i + 1));
            if (prevNum < curNum) {
                sum -= prevNum;
            } else {
                sum += prevNum;
            }

            if (i == s.length() - 2) {
                sum += curNum;
            }
        }

        return sum;
    }

}