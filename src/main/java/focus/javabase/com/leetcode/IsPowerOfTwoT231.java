package focus.javabase.com.leetcode;

public class IsPowerOfTwoT231 {

    // 除法 取模
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int mod = 0;
        while (n > 1) {
            mod = n % 2;
            if ((mod & 1) == 1) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }

    // 逐个比较
    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        for (int i = 0; i < 31; i++) {
            int a = (1 << i);
            if (a == n) {
                return true;
            }
        }
        return false;
    }
}