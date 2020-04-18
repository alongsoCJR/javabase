package focus.javabase.com.leetcode;

//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5

public class LengthOfLastWordT058 {

    // "a "  1
    public static int lengthOfLastWord(String s) {
        assert s != null;
        String string = s.trim();
        int i = 0, j;
        for (j = string.length() - 1; j >= 0 && string.charAt(j) != ' '; j--) {
            i++;
        }
        return i;
    }


    //
    public static int lengthOfLastWord1(String s) {
        assert s != null;
        int i = 0, j;
        for (j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == ' ') {
                if (i == 0) {
                    continue;
                }
                break;
            }
            i++;
        }
        return i;
    }


    public static int lengthOfLastWord2(String s) {
        assert s != null;
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int i = 0, j;
        for (j = end; j >= 0 && s.charAt(j) != ' '; j--) {
            i++;
        }
        return i;
    }
}