package focus.javabase.com.leetcode;

public class ReverseBitsT190 {

    public static int reverseBits(int n) {

        // 将int类型转化成str  00000010100101000001111010011100  //转化之后不保留32位
        String inputStr = Integer.toBinaryString(n);

        // 遍历str，进行反转
        StringBuilder sb = new StringBuilder(inputStr);

        // str转二进制
        return Integer.parseUnsignedInt(sb.reverse().toString(), 2);
    }

    // 位运算 11111111111111111111111111111101(参考-取模）
    public static int reverseBits1(int n) {
        int ret = 0;
        int power = 31;
        for (int i = 0; i <= power; i++) {
            ret = (ret << 1) + (n & 1);
            n = n >> 1;
        }
        return ret;
    }

    // 参考 异或(00000000000000000000000000001111)
    public static int reverseBits2(int n) {
        int ret = 0;
        int power = 31;
        for (int i = 0; i <= power; i++) {
            int a = (n & (1 << i));
            ret ^= a != 0 ? 1 << (31 - i) : 0;
        }
        return ret;
    }

    //{
    //        int ret = 0;
    //        int power = 31;
    //        while (n != 0) {
    //            ret += (n & 1) << power;
    //            n = n >> 1;
    //            power--;
    //        }
    //        return ret;
    //    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }
}