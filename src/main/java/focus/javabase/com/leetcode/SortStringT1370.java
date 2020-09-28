package focus.javabase.com.leetcode;

public class SortStringT1370 {

    public static String sortString(String s) {
        char[] chars = new char[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            count++;
        }


        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    chars[i]--;
                    count--;
                }
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] > 0) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    chars[i]--;
                    count--;
                }
            }
        }

        return sb.toString();

    }
}