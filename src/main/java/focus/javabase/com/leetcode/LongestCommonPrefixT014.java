package focus.javabase.com.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
public class LongestCommonPrefixT014 {

    public static String longestCommonPrefix(String[] strs) {
        assert strs != null;
        String returnStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            returnStr = commonPrefix(returnStr, str);
            if (returnStr == "") {
                break;
            }
        }
        return returnStr;
    }

    // 如何优化 ？
    private static String commonPrefix(String returnStr, String str) {
        String commonPrefix = "";
        int index = returnStr.length() > str.length() ? str.length() : returnStr.length();
        for (int i = 0; i < index; i++) {
            if (str.charAt(i) != returnStr.charAt(i)) {
                break;
            }
            commonPrefix += str.charAt(i);
        }
        return commonPrefix;
    }

    // 如何优化 ？
    private static String commonPrefix1(String returnStr, String str) {
        String commonPrefix = "";
        int index = returnStr.length() > str.length() ? str.length() : returnStr.length();
        for (int i = 0; i < index; i++) {
            char c = returnStr.charAt(i);
            if (str.charAt(i) != c) {
                break;
            }
            commonPrefix += str.charAt(i);
        }
        return commonPrefix;
    }

    // leetcode第一种解法
    public static String longestCommonPrefixFromLeet(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 迭代 逐个比较
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    // {0,1,2,3,...n}
    // fun(n)=fun((fun(fun(1,2),3),...),n);
    // 递归如何写？分治?
//    public static String longestCommonPrefixByRecursion(String[] strs) {
////        assert strs != null;
////        return commonPrefixByRecursion(strs, 0, strs.length - 1);
////    }
////
////
////    // 界限？参考快排和归并
////    private static String commonPrefixByRecursion(String[] strings, int low, int high) {
////        String result = "";
////        if (low < high) {
////            int mid = (low + high) >> 1;
////            commonPrefixByRecursion(strings, low, mid);
////            commonPrefixByRecursion(strings, mid + 1, high);
////            result = mergeCommomPrefix(strings, low, mid, high);
////        } else {
////            result = strings[low];
////        }
////        return result;
////    }
////
////    private static String mergeCommomPrefix(String[] strings, int left, int mid, int right) {
////        int i = left;
////        int j = mid + 1;
//////        String leftPrefix = strings[i];
////        String leftPrefix = strings[i];
////        if (i < mid) {
////            leftPrefix = commonPrefix(strings[i], strings[mid]);
////        }
////
//////        while (i <= mid) {
//////            while (strings[i].indexOf(leftPrefix) != 0) {
//////                leftPrefix = leftPrefix.substring(0, leftPrefix.length() - 1);
//////                if (leftPrefix.isEmpty()) {
//////                    break;
//////                }
//////            }
//////            i++;
//////        }
////
//////        String rightPrefix = strings[j];
////        String rightPrefix = strings[j];
////        if (j < right) {
////            rightPrefix = commonPrefix(strings[j], strings[right]);
////        }
//////        while (j <= right) {
//////            while (strings[j].indexOf(rightPrefix) != 0) {
//////                rightPrefix = rightPrefix.substring(0, rightPrefix.length() - 1);
//////                if (rightPrefix.isEmpty()) {
//////                    break;
//////                }
//////            }
//////            j++;
//////        }
////        return commonPrefix(leftPrefix, rightPrefix);
////    }


    public static String longestCommonPrefixByRecursion(String[] strs) {
        assert strs != null;
        if (strs.length == 0) {
            return "";
        }
        return commonPrefixByRecursion(strs, 0, strs.length - 1);
    }


    // 界限？参考快排和归并
    private static String commonPrefixByRecursion(String[] strings, int low, int high) {
        String result = "";
        if (low < high) {
            int mid = (low + high) >> 1;
            String leftPrefix = commonPrefixByRecursion(strings, low, mid);
            String rightPrefix = commonPrefixByRecursion(strings, mid + 1, high);
            return mergeCommomPrefix(leftPrefix, rightPrefix);
        } else {
            result = strings[low];
        }
        return result;
    }

    private static String mergeCommomPrefix(String returnStr, String str) {
        String prefix = returnStr;
        while (str.indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if ("".equals(prefix)) {
                return "";
            }
        }
        return prefix;
    }


    // 求n的阶乘  n*(n-1)*(n-2)*...*1
    private static long mul(long n) {
        if (n == 1) {
            return 1;
        }
        return mul(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(mul(3));
    }
}