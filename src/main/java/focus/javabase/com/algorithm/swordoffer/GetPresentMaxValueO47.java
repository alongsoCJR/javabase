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
}