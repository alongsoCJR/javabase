package focus.javabase.com.leetcode;

/**
 * @author Jianrong.Chen
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class NthUglyNumberT264 {

    public static int nthUglyNumber(int n) {
        int index = 0;
        int count = 0;
        while (count < n) {
            if (isUgly(++index)) {
                count++;
            }
        }
        return index;
    }

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        } else {
            while (num % 2 == 0) {
                num = num / 2;
            }

            while (num % 3 == 0) {
                num = num / 3;
            }

            while (num % 5 == 0) {
                num = num / 5;
            }
        }
        return num == 1;
    }

    public static int nthUglyNumber0(int n) {
        if (n < 1) {
            return -1;
        }

        int index = 0;
        int[] result = new int[n];
        int numberIdx2 = 0, numberIdx3 = 0, numberIdx5 = 0;
        int number2 = 0, number3 = 0, number5 = 0;
        result[index++] = 1;
        for (; index < n; index++) {
            int maxUglyNumber = result[index - 1];
            while (numberIdx2 < index && 2 * result[numberIdx2] <= maxUglyNumber) {
                numberIdx2++;
            }
            number2 = 2 * result[numberIdx2];

            while (numberIdx3 < index && 3 * result[numberIdx3] <= maxUglyNumber) {
                numberIdx3++;
            }
            number3 = 3 * result[numberIdx3];

            while (numberIdx5 < index && 5 * result[numberIdx5] <= maxUglyNumber) {
                numberIdx5++;
            }
            number5 = 5 * result[numberIdx5];

            result[index] = Math.min(Math.min(number2, number3), number5);
        }

        return result[n - 1];
    }

    // 参考
    public static int nthUglyNumber1(int n) {
        if (n < 1) {
            return -1;
        }

        int[] idxs = new int[n];
        int i1 = 0, i2 = 0, i3 = 0;
        idxs[0] = 1;
        for (int index = 0; index < n; index++) {
            int min = Math.min(Math.min(2 * idxs[i1], 3 * idxs[i2]), 5 * idxs[i3]);
            if (min == 2 * idxs[i1]) {
                i1++;
            }

            if (min == 3 * idxs[i2]) {
                i2++;
            }

            if (min == 5 * idxs[i3]) {
                i3++;
            }
            idxs[index] = min;
        }

        return idxs[n - 1];
    }

    // 小顶堆
    public static int nthUglyNumber2(int n) {
        return -1;
    }
}