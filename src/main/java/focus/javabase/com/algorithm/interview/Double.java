package focus.javabase.com.algorithm.interview;

/**
 * 字符转小树 默认输入 X  输出 X
 * 禁用 parseXXX,X Math.pow,1.2e7 d f 无效
 *
 * @author Jianrong.Chen
 */
public class Double {

    // A[.B]  A的取值0-9 B的取值为0-9  [.B]有小数点的话，B不能为空
    public static double parseDouble(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }
        String[] arrs = s.split("#");
        // 处理整数部分
        int num1 = 0;
        if (arrs.length > 0 && arrs[0].length() > 0) {
            num1 = parseInt(arrs[0]);
        }
        // 处理小数部分
        double result = num1;
        int num2 = 0;
        if (arrs.length > 1 && arrs[1].length() > 0) {
            num2 = parseInt(arrs[1]);
            double b = 1;
            for (int i = 0; i < arrs[1].length(); i++) {
                b = b * 10.0;
            }
            result = result + num2 / b;
        }
        return result;
    }

    private static int parseInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';
            result = result * 10 + a;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("12"));
    }
}