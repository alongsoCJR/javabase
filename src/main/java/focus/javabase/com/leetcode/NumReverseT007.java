package focus.javabase.com.leetcode;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 ***/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjianrong-lhq 2019年07月16日 19:27:51
 * @Description:
 * @ClassName: NumReverseT007
 */
public class NumReverseT007 {

    public static int reverse(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        String numStr = "";
        int num = 0;
        int[] bit = new int[32];
        int i = 0;
        while (x >= 1) {
            bit[i++] = x % 10;
            x /= 10;
        }

        for (int j = 0; j < bit.length; j++) {
            if (bit[j] != 0) {
                numStr += bit[j] + "";
            }
        }
        return negative ? -Integer.parseInt(numStr) : Integer.parseInt(numStr);
    }

    public static int reverse0(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            /**这里尴尬了，我的天啊，取相反数越界了**/
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            x = -x;
        }
        String numStr = "";
        int num = 0;
        List<Integer> bitList = new ArrayList<>();
        int i = 0;
        while (x >= 1) {
            bitList.add(x % 10);
            x /= 10;
        }
        boolean flag = true;
        for (Integer number : bitList) {
            if (number == 0 && flag) {
                continue;
            }
            numStr += number + "";
            flag = false;
        }

        if ("".equals(numStr)) {
            numStr = x + "";
        }
        /**怎么判断相反数是否越界？**/
        if (Long.valueOf(numStr) > Integer.MAX_VALUE || -Long.valueOf(numStr) < Integer.MIN_VALUE) {
            return 0;
        }
        /**解决正反数统一处理的问题**/
        return negative ? -Integer.parseInt(numStr) : Integer.parseInt(numStr);
    }

    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 用ArrayList实现
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static int reverse1(int x) {
        /** Integer.MIN_VALUE 取相反数时特殊，需做特殊处理**/
        if (x <= Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        String numStr = "";
        int num = 0;
        List<Integer> bitList = new ArrayList<>();
        int i = 0;
        while (x >= 1) {
            bitList.add(x % 10);
            x /= 10;
        }
        boolean flag = true;
        for (Integer number : bitList) {
            if (number == 0 && flag) {
                continue;
            }
            numStr += number + "";
            flag = false;
        }
        /**怎么判断reverse是否越界？**/
        if (Long.valueOf(numStr) > Integer.MAX_VALUE || -Long.valueOf(numStr) < Integer.MIN_VALUE) {
            return 0;
        }
        /**解决正反数统一处理的问题**/
        return negative ? -Integer.parseInt(numStr) : Integer.parseInt(numStr);
    }


    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 利用ArrayDeque 队列的特性 先进先出  进行实现
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static int reverse2(int x) {
        /** Integer.MIN_VALUE 取相反数时特殊，需做特殊处理**/
        if (x <= Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        String numStr = "";
        Long num = 0L;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int i = 0;
        while (x >= 1) {
            arrayDeque.offer(x % 10);
            x /= 10;
        }

        boolean flag = true;

        while (!arrayDeque.isEmpty()) {
            Integer number = arrayDeque.poll();
            if (number == 0 && flag) {
                continue;
            }
            numStr += number + "";
            flag = false;
        }
        num = Long.valueOf(numStr);
        /**怎么判断reverse是否越界？ 可以将num定义为long类型，将不用多次转化了**/
        if (num > Integer.MAX_VALUE || -num < Integer.MIN_VALUE) {
            return 0;
        }
        /**如何解决正反数统一处理的问题? 控制while条件**/
        return negative ? -num.intValue() : num.intValue();
    }


    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 在不使用数组 和 队列的情况下，求出反转数
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static int reverse3(int x) {
        boolean negative = x >= 0 ? false : true;
        x = Math.abs(x);
        int rev = 0;
        while (x >= 1) {
            int pop = x % 10;
            x = x / 10;
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return negative ? -rev : rev;
    }


    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 处理正负数
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static int reverse4(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < (Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }


    /**
     * @return
     * @Author chenjianrong-lhq
     * @Description 利用ArrayDeque 栈的特性 先进后出  进行实现
     * @Date 2019-07-17 15:55
     * @Param
     **/
    public static int reverse5(int x) {
        /** Integer.MIN_VALUE 取相反数时特殊，需做特殊处理**/
        if (x <= Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0) {
            return 0;
        }
        Long num = 0L;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int i = 0;
        while (x != 0) {
            arrayDeque.push(x % 10);
            x /= 10;
        }
        boolean flag = true;
        int n = 0;
        while (!arrayDeque.isEmpty()) {
            Integer number = arrayDeque.pop();
            if (number == 0 && flag) {
                continue;
            }
//            num = num + number * 10 ^ n;
            Long temp = number * new Double(Math.pow(10, n)).longValue();
            if (num > Integer.MAX_VALUE || temp > Integer.MAX_VALUE || num + temp > Integer.MAX_VALUE) {
                return 0;
            }
            if (-num < Integer.MIN_VALUE || temp < Integer.MIN_VALUE || num + temp < Integer.MIN_VALUE) {
                return 0;
            }
            num += temp;
            n++;
            flag = false;
        }
        /**如何解决正反数统一处理的问题? 控制while条件**/
        return num.intValue();
    }

}
