package focus.javabase.com.leetcode;

public class FindTheDifferenceT389 {

    public static char findTheDifference(String s, String t) {
        int result = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            int s1 = s.charAt(i);
            int t1 = t.charAt(i);
            result = result ^ (s1 ^ t1);
        }
        return (char) result;
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 10);
    }
}