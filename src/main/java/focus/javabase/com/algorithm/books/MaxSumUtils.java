package focus.javabase.com.algorithm.books;

/**
 * @author chenjianrong-lhq 2019年07月26日 18:48:23
 * @Description: 最大字段和 测试类
 * @ClassName: MaxSumUtils
 */
public class MaxSumUtils {


    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 最大字段和 计算方法
     * @Date 2019-07-26 18:54
     * @Param [intArr] todo {-2, 11, -4, 13, -5, -2}
     **/
    public static int maxSum(int[] intArr) {
        int len = intArr.length;
        int besti, bestj = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int thisSum = 0;

                /**为什么不用k < len，会导致更多的重复计算**/
                for (int k = i; k <= j; k++) {
                    thisSum += intArr[k];
                    if (thisSum > sum) {
                        sum = thisSum;
                        besti = i;
                        bestj = j;
                    }
                }
            }
        }
        return sum;
    }


    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 书本上优化后的案例
     * @Date 2019-07-28 11:21
     * @Param [intArr]
     **/
    public static int maxSum0(int[] intArr) {
        int len = intArr.length;
        int besti, bestj = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int thisSum = 0;
            for (int j = i; j < len; j++) {
                thisSum += intArr[j];
                if (thisSum > sum) {
                    sum = thisSum;
                    besti = i;
                    bestj = j;
                }
            }
        }
        return sum;
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 动态规划
     * @Date 2019-07-28 11:22
     * @Param [intArr]
     **/
    public static int maxSum1(int[] intArr) {
        int len = intArr.length;
        int sum = 0;
        int thisSum = 0;
        for (int i = 0; i < len; i++) {
            if (thisSum > 0) {
                thisSum += intArr[i];
            } else {
                thisSum = intArr[i];
            }

            if (thisSum > sum) {
                sum = thisSum;
            }
        }
        return sum;
    }
}
