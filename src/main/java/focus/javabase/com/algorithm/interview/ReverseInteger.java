package focus.javabase.com.algorithm.interview;

/**
 * @Author Jianrong.Chen
 * @Description gsx 二面
 * @Date 2021-03-24 12:15
 **/
public class ReverseInteger {

    public static int reverseInteger(int num) {
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
            num = Math.abs(num);
        }

        // 处理0以及以0结尾的数字
        if (num == 0) {
            return 0;
        }
        // num%10==0
        while ((num % 10) == 0) {
            num = num / 10;
        }

        String result = "";
        int n = 0;
        while (num > 0) {
            n = num % 10;
            result += n;
            num = num / 10;
        }

        // 处理正负数
        return isPositive ? Integer.valueOf(result) : -Integer.valueOf(result);
    }


    public static int reverseInteger1(int num) {
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
            num = Math.abs(num);
        }

        // 处理以0结尾的数字
        while (num > 0 && (num % 10) == 0) {
            num = num / 10;
        }

        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }

        // 处理正负数
        return isPositive ? result : -result;
    }

}