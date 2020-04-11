package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenjianrong-lhq 2019年07月23日 09:23:06
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * "dvdf" --> "vdf"
 * "wwkep"--> "wkep"
 */
public class LengthOfLongestSubstringT003 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        /**step 1 求出所有字符**/
        char[] charArr = s.toCharArray();
        String longestStr = "";

        /**step 2 按照集合顺序进行组合**/
        for (int i = 0; i < charArr.length; i++) {
            if (!longestStr.contains(charArr[i] + "")) {
                longestStr = longestStr.concat(charArr[i] + "");
            } else {
                continue;
            }
        }
        /**step 3 这个方法能优化吗？ 感觉行不通，设计思想有问题？是否应该使用动态规划？**/
        while (!s.contains(longestStr)) {
            longestStr = longestStr.substring(1, longestStr.length());
        }
        return longestStr.length();
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 参考动态规划 最大字段和算法
     * @Date 2019-07-28 10:09
     * @Param [s]
     **/
    public static int lengthOfLongestSubstring0(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        /**step 1 求出所有字符**/
        char[] charArr = s.toCharArray();
        String longestStr = "";
        boolean clearFlag = false;
        boolean isFirst = true;
        for (int i = 0; i < charArr.length; i++) {
            String thisStr = "";
            String tempStr = "";
            for (int j = i; j < charArr.length; j++) {
                if (!thisStr.contains(charArr[j] + "")) {
                    thisStr += charArr[j];
                } else {
                    clearFlag = true;
                    if (!tempStr.contains(charArr[j] + "")) {
                        tempStr = charArr[j] + "";
                    }
                }
                if (thisStr.length() > longestStr.length()) {
                    longestStr = thisStr;
                }
                if (clearFlag) {
                    thisStr = tempStr;
                    clearFlag = false;
                }
            }
        }
        return longestStr.length();
    }


    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        /**step 1 求出所有字符**/
        char[] charArr = s.toCharArray();
        String longestStr = "";
        boolean clearFlag = false;
        for (int i = 0; i < charArr.length; i++) {
            String thisStr = "";
            for (int j = i; j < charArr.length; j++) {
                if (!thisStr.contains(charArr[j] + "")) {
                    thisStr += charArr[j];
                } else {
                    clearFlag = true;
                }
                if (thisStr.length() > longestStr.length()) {
                    longestStr = thisStr;
                }
                if (clearFlag) {
                    thisStr = charArr[j] + "";
                    clearFlag = false;
                }
            }
        }
        return longestStr.length();
    }


    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 这个算法的时间复杂度达到了n(o ^ 3)
     * @Date 2019-07-28 12:09
     * @Param
     **/

    public static String lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        /**step 1 求出所有字符**/
        char[] charArr = s.toCharArray();
        String longestStr = "";
        boolean clearFlag = false;
        for (int i = 0; i < charArr.length; i++) {
            String thisStr = "";
            for (int j = i; j < charArr.length; j++) {
                if (!thisStr.contains(charArr[j] + "")) {
                    thisStr += charArr[j];
                } else {
                    clearFlag = true;
                }
                if (thisStr.length() > longestStr.length()) {
                    longestStr = thisStr;
                }
                if (clearFlag) {
                    thisStr = charArr[j] + "";
                    clearFlag = false;
                }
            }
        }
        return longestStr;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 参考答案，滑动窗口
     * @Date 2019-07-29 09:10
     * @Param [s]
     **/
    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> characterSet = new HashSet<>();
        while (i < len && j < len) {
            if (!characterSet.contains(s.charAt(j))) {
                characterSet.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                characterSet.remove(s.charAt(i++));
            }

        }
        return ans;
    }


    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 滑动窗口的优化
     * @Date 2019-07-29 09:49
     * @Param [s]
     **/
    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (charMap.containsKey(s.charAt(j))) {
                i = Math.max(charMap.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            charMap.put(s.charAt(j), j + 1);

        }
        return ans;
    }


    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 滑动窗口的优化, 利用char最多128个字符
     * todo  int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
     *       int [128] 用于ASCII码
     *       int [256] 用于扩展ASCII码
     * @Date 2019-07-29 09:49
     * @Param [s]
     **/
    public static int lengthOfLongestSubstring5(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int ans = 0;
        int[] charArr = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(charArr[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            charArr[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static String lengthOfLongestSubstring6(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        /**step1 求出所有字符**/
        char[] charArr = s.toCharArray();
        String longestStr = "";
        String thisStr = "";
        for (int i = 0; i < charArr.length; i++) {
            if (!thisStr.contains(charArr[i] + "")) {
                thisStr += charArr[i];
            } else {
                thisStr += charArr[i];
            }

            if (thisStr.length() > longestStr.length()) {
                longestStr = thisStr;
            }
        }
        return longestStr;
    }


}
