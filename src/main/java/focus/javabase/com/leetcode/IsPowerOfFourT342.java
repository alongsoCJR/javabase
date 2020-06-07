package focus.javabase.com.leetcode;

public class IsPowerOfFourT342 {

    // while
    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num = num >> 2;
        }
        return num == 1;
    }


    // 逐位比较
    public static boolean isPowerOfFour1(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        for (int i = 1; i < 15; i++) {
            if (num == (4 << 2 * i)) {
                return true;
            }
        }
        return false;
    }

    // 参考
    public static boolean isPowerOfFour2(int num) {
//        return num > 0 && ((num & (num - 1)) == 0) &&
//                (num % 3 == 1);

//        return num > 0 && ((num & (num - 1)) == 0) &&
//                ((num & 0x55555555) == num);

        return num > 0 && ((num & (num - 1)) == 0) &&
                ((num & 0xaaaaaaaa) == 0);

    }

}