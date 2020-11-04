package focus.javabase.com.algorithm.swordoffer;

/**
 * @author chenjianrong
 * 求base的exponent次方
 */
public class PowerO16 {

    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }


    public static double power1(double x, int n) {
        // 特殊字符输入
        if (n == 0 || x == 1) {
            // 0^0次方也默认为1
            return 1;
        }

        if (x == -1) {
            if ((n & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (n == Integer.MIN_VALUE) {
            return 0;
        }

        double result = 1;
        // 指数取正(考虑n=Integer.MIN的问题)
        int index = n < 0 ? -n : n;
        for (int i = 0; i < index; i++) {
            result *= x;
        }
        if (x != 0 && n < 0) {
            return 1 / result;
        }
        return result;
    }

    // 快速幂 + 递归

    public static double power2(double x, long n) {
        // 特殊字符输入
        if ((x == 0 && n < 0)) {
            return 1;
        }

        double result = 1;
        // 指数取正(考虑n=Integer.MIN的问题)
        long index = n < 0 ? -n : n;
        result = getPowerByRecursion(index, x);
        if (x != 0 && n < 0) {
            return 1 / result;
        }
        return result;
    }

    private static double getPowerByRecursion(long index, double x) {
        double result = 1;
        if (index == 0) {
            return 1;
        }

        if (index == 1) {
            return x;
        }
        result = getPowerByRecursion(index >> 1, x);
        result *= result;
        if ((index & 1) == 1) {
            result *= x;
        }
        return result;
    }

}