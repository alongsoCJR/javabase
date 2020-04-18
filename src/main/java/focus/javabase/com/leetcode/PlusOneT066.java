package focus.javabase.com.leetcode;

public class PlusOneT066 {


    public static int[] plusOne(int[] digits) {
        assert digits != null && digits.length > 0;
        int len = digits.length - 1;
        boolean isIncr = false;
        while (len >= 0 || isIncr) {
            int i = digits[len];
            if ((++i) == 10) {
                digits[len] = 0;
                isIncr = true;
            } else {
                digits[len] = i;
                break;
            }
            len--;

            // 如果999，则需要数组扩容
            if (len < 0) {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j + 1] = digits[j];
                }
                return arr;
            }
        }
        return digits;
    }


    public static int[] plusOne1(int[] digits) {
        assert digits != null && digits.length > 0;
        int len = digits.length - 1;
        boolean isIncr = false;
        while (len >= 0 || isIncr) {
            int i = digits[len];
            if ((++i) == 10) {
                digits[len] = 0;
                isIncr = true;
            } else {
                digits[len] = i;
                break;
            }
            len--;

            // 如果999，则需要数组扩容(新建数组默认为0)
            if (len < 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                break;
            }
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        assert digits != null && digits.length > 0;
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}