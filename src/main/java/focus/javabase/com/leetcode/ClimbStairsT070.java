package focus.javabase.com.leetcode;


import java.util.Stack;

public class ClimbStairsT070 {

    // 2,2
    // f(3)=f(2)+f(1)
    // f(4)=f(3)+f(2)=2f(2)+f(1)  =5
    // f(5)=f(4)+f(3)=2f(2)+f(1) + f(2)+f(1)= 3f(2)+2f(1) =8 ...  (n-1)
    // f(6)=f(5)+f(4)=3f(2)+2f(1) + 2f(2)+f(1) = 5f(2)+3f(1)
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 5
    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        // 5 4 3 2
        int result = 0;
        int firstResult = 1;
        int secondResult = 2;

        while (n > 2) {
            result = (firstResult + secondResult);
            firstResult = secondResult;
            secondResult = result;
            n--;
        }
        return result;
    }


    public static int mul(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        return n * mul(n - 1);

        int result = 1;
        while (n >= 1) {
            result = n * result;
            n--;
        }

        return result;
    }


    public static void main(String[] args) {
        //3628800
        System.out.println(mul(10));
    }
}