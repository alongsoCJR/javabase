package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description 数轴跳法，有(x，y)的数轴，x为横坐标，y为众坐标，
 * 现从（0，0）的位置走到（m，n）的位置，m>0,n>0有多少种走法？
 * @Date 2020-03-30 09:27
 **/
public class AxisStip {

    public static final int mPostionArrs[] = {1, 2, 3, 5, 12};
    public static final int nPostionArrs[] = {2, 3, 4, 6, 12};

    public static void main(String[] args) {

        for (int i = 0; i < mPostionArrs.length; i++) {
            int m = mPostionArrs[i];
            int n = nPostionArrs[i];
            System.out.print("(m，n)的坐标为：(" + m + "," + n + ")");
            System.out.println("走法一共有：" + foward(m, n) + "种！");

        }
    }

    // 递归
    static int foward(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        return foward(m - 1, n) + foward(m, n - 1);
    }
}