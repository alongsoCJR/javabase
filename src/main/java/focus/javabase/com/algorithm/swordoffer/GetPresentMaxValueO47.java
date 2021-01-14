package focus.javabase.com.algorithm.swordoffer;

public class GetPresentMaxValueO47 {

    // 递归 从上至下（自顶向下）
    public static int getPresentMaxValue(int[][] args, int i, int j) {
        if (i == 0 || j == 0) {
            return getAllTotal(args, i, j);
        }
        return args[i][j] + Math.max(getPresentMaxValue(args, i - 1, j)
                , getPresentMaxValue(args, i, j - 1));
    }

    private static int getAllTotal(int[][] args, int i, int j) {
        int total = 0;
        if (i == 0) {
            for (int k = 0; k <= j; k++) {
                total += args[i][k];
            }
        } else if (j == 0) {
            for (int k = 0; k <= i; k++) {
                total += args[k][j];
            }
        }
        return total;
    }

    // 迭代实现 （自底向上）
    // 1, 10, 3, 8
    // 12, 2, 9, 6
    // 5, 7, 4, 11
    // 3, 7, 16, 5

    // 1, 11, 14, 22
    // 13,15, 24, 30
    // 18,25, 28, 41
    // 21,32, 48, 53
    public static int getPresentMaxValue2(int[][] args, int i, int j) {
        int[][] result = new int[i + 1][j + 1];
        for (int n = 0; n <= i; n++) {
            for (int m = 0; m <= j; m++) {
                int left = 0;
                int up = 0;
                if (m > 0) {
                    left = result[n][m - 1];
                }
                if (n > 0) {
                    up = result[n - 1][m];
                }

                result[n][m] = Math.max(left, up) + args[n][m];
            }
        }
        return result[i][j];
    }

    // 有多少种走法 目的地
    public static int getWaysToDestination(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }

        if (x == 0 || y == 0) {
            return 1;
        }
        return getWaysToDestination(x, y - 1) + getWaysToDestination(x - 1, y);
    }
}