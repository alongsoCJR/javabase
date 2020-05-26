package focus.javabase.com.leetcode;

import java.math.BigInteger;
import java.util.Scanner;

public class TrailingZeroesT172 {


    // 超出时间限制
    public static int trailingZeroes(int n) {
        String result = function(new BigInteger(n + "")).toString();
        if ("0".equals(result)) {
            return 0;
        }
        char c = ' ';
        int ret = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            c = result.charAt(i);
            if (c != '0') {
                break;
            }
            ret++;
        }
        return ret;
    }

    public static BigInteger function(BigInteger n) {
        if (BigInteger.ONE.compareTo(n) >= 0) {
            return n;
        }
        return n.multiply(function(n.subtract(BigInteger.ONE)));
    }

    // 参考
    public static int trailingZeroes1(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 0;
        while (true) {
            // 13 越界
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
            System.out.println(trailingZeroes1(a) + "---" + trailingZeroes(a));
        }
    }
}