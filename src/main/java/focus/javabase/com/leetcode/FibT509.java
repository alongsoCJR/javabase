package focus.javabase.com.leetcode;

public class FibT509 {

    // 递归
    public static int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }


    // 迭代
    public static int iterativelyFib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = 0;  // f(3)=f(1)+f(2) f(2)=f(0)+f(1)
        for (int i = 1; i < N; i++) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }
}