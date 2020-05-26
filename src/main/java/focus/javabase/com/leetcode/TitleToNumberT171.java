package focus.javabase.com.leetcode;

import java.util.Scanner;

public class TitleToNumberT171 {

    public static int titleToNumber(String s) {
        int ret = 0;
        int i = 0;
        int a = 0;
        int b = 0;
        while (!"".equals(s)) {
            char c = s.charAt(s.length() - 1);
            a = c - 'A' + 1;
            // pow效率不高
            b = (int) Math.pow(26, i);
            ret += a * b;
            s = s.substring(0, s.length() - 1);
            i++;
        }
        return ret;
    }

    // 参考
    public static int titleToNumber1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }


    public static void main(String[] args) {
        String a = "";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextLine();
            System.out.println(titleToNumber1(a));
        }
    }
}