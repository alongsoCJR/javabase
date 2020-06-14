package focus.javabase.com.leetcode;

import java.util.Scanner;

public class ToHexT405 {

    public static String toHex(int num) {
        int div = num;
        String ret = "";
        if (div == 0) {
            return "0";
        }
        while (div != 0) {
            int mod = div & 0xf;
            if (mod > 9) {
                ret = ((char) (mod - 10 + 'a')) + ret;
            } else {
                ret = mod + ret;
            }
            // 无符号右移
            div = div >>> 4;
        }
        return ret;
    }

    // 优化
    public static String toHex1(int num) {
        int div = num;
        String ret = "";
        char[] binaryChars = "0123456789abcdef".toCharArray();
        if (div == 0) {
            return "0";
        }
        while (div != 0) {
            int mod = div & 0xf;
            if (mod > 9) {
                ret = binaryChars[mod] + ret;
            } else {
                ret = mod + ret;
            }
            // 无符号右移
            div = div >>> 4;
        }
        return ret;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            String binary = toHex1(a);
            System.out.println(binary);
        }
    }
}