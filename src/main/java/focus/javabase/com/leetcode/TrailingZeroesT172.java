package focus.javabase.com.leetcode;

import java.math.BigInteger;
import java.util.Scanner;

public class TrailingZeroesT172 {


    // 超出时间限制
    public static int trailingZeroes(int n) {
        BigInteger ten = new BigInteger("10");
        BigInteger result = function(new BigInteger(n + ""));
        int ret = 0;
        while (ten.compareTo(result) < 0) {
            if (BigInteger.ZERO.compareTo(result.mod(ten)) == 0) {
                ret++;
                result = result.divide(ten);
            } else {
                break;
            }
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