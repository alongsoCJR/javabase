package focus.javabase.com.leetcode;

import java.math.BigInteger;

public class MySqrtT069 {


    // 2^2<8<3^2
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int result = 0;
        BigInteger n = new BigInteger(x + "");
        BigInteger m = new BigInteger("0");
        while (m.compareTo(n) == -1) {
            m = new BigInteger(Math.pow(++result, 2) + "");
        }
        return m.compareTo(n) == 0 ? result : result - 1;
    }

    public static int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int result = 0;
        double m = 0.0;
        while (m < x) {
            m = Math.pow(++result, 2);
        }
        return m - x == 0 ? result : result - 1;
    }
}