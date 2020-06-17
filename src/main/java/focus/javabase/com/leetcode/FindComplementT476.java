package focus.javabase.com.leetcode;

public class FindComplementT476 {

    public static int findComplement(int num) {
        int result = 0;
        int i = 0;
        while (num != 0) {
            result += (((num & 1) ^ 1) << i);
            num = num >> 1;
            i++;
        }
        return result;
    }
}