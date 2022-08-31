package focus.javabase.com.algorithm.interviewer;

/**
 * @Author Jianrong.Chen
 * @Description 字符串转小数
 * @Date 2022-03-02 20:28
 */
public class Double {

    public static final double EPS = 1e-7;

    public static double sqart(double n) {
        if (n <= 0) {
            throw new RuntimeException("can't be zero or naggitive");
        }
        double x = 100000;
        double lastX = x + 1 + EPS;
        double diff = Math.abs(x - lastX);
        while (x - lastX > EPS || lastX - x > EPS) {
            lastX = x;
            x = (x + n / x) / 2;
            diff = Math.abs(x - lastX);
        }
        return x;
    }
}