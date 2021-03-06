package focus.javabase.com.leetcode;


public class HasAlternatingBitsT693 {

    public static boolean hasAlternatingBits(int n) {
        int a = n & 1;
        while (n > 0) {
            if ((a ^ ((n >> 1) & 1)) == 0) {
                return false;
            }
            a = (n >> 1) & 1;
            n = n >> 1;
        }
        return true;
    }

    // 优化
    public static boolean hasAlternatingBits1(int n) {
        while (n > 0) {
            if ((n & 1 ^ ((n >> 1) & 1)) == 0) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }

    // 参考
    public static boolean hasAlternatingBits2(int n) {
        int num = (n ^ (n >> 1)) + 1;
        return (num & (num - 1)) == 0;
    }


    // if (n > 2 && (n & (n - 1)) == 0) {
    //            return false;
    //        }
    //        return (n ^ 0x55555555) == (n + 0x55555555) || (n ^ 0xaaaaaaaa) == (n + 0xaaaaaaaa);


    //{
    //        while (n > 0) {
    //            if (((((n) & 1)) ^ (((n >> 1) & 1))) == 0) {
    //                return false;
    //            }
    //            n = n >> 2;
    //        }
    //        return true;
    //    }
    public static void main(String[] args) {
        System.out.println(5 >> 2);
    }
}