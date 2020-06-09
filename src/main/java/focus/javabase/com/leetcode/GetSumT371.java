package focus.javabase.com.leetcode;

public class GetSumT371 {

    public static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}