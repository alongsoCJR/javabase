package focus.javabase.com.leetcode;

public class HammingWeightT191 {

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            int bit = n & (1 << i);
            if (bit != 0) {
                count++;
            }
        }
        return count;
    }


    public static int hammingWeight2(int n) {
        int count = 0;
        int bit = 0;
        for (int i = 0; i <= 31; i++) {
            bit = n & 1;
            if (bit == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}