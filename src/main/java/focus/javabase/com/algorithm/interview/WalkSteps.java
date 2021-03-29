package focus.javabase.com.algorithm.interview;

/**
 * @Author Jianrong.Chen
 * @Description 假设你正在爬楼梯, 你一次只能爬一个或者两个台阶, 现在你要爬N阶楼梯, 问有多少种方法。
 *      tt面试题
 * @Date 2021-03-24 21:40
 **/
public class WalkSteps {

    public static void main(String[] args) {
        int steps = step(8);
        if (steps == 13) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail! steps=" + steps);
        }
    }

    // 添加条件，为7的倍数的台阶必须跨过去，不能停
    public static int step(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            // 为7的倍数时 为f(i)=0
            if (i % 7 == 0) {
                result = 0;
            } else {
                result = first + second;
            }
            first = second;
            second = result;
        }
        return result;
    }

    public static int step0(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return step0(n - 1) + step0(n - 2);
    }
}