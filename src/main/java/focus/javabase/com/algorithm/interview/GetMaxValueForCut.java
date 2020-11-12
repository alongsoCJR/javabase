
package focus.javabase.com.algorithm.interview;

/**
 * @author chenjianrong
 * <p>
 * 钢条切割问题
 * <p>
 * [1,2,3]
 * <p>
 * 两种情况：不包含1，从[2,3]取10
 * 包含1，从[1,2,3]取9
 */


public class GetMaxValueForCut {

    private static int maxValue = 0;

    public static int cutForMaxValue(int totalLength, int[] values) {
        if (totalLength == 0 || values == null || values.length == 0) {
            return maxValue;
        }
        cut(totalLength, values, 0, 0);
        return maxValue;
    }

    /**
     * 递归实现
     *
     * @param totalLength 总长度
     * @param values      价值数组
     * @param idx         下标
     * @param total       总长
     */
    private static void cut(int totalLength, int[] values, int idx, int total) {
        if (idx == values.length) {
            return;
        }

        if (totalLength == 0) {
            maxValue = Integer.max(maxValue, total);
            return;
        }
        //不包含1
        cut(totalLength, values, idx + 1, total);

        if (totalLength >= idx + 1) {
            // 包含1
            cut(totalLength - idx - 1, values, idx, total + values[idx]);
        }
    }

    /**
     * 自顶向下计算
     * f(10)=Max{f(9)+p1,f(8)+p2,f(7)+p3}
     * <p>
     * f(1)=p1
     * f(2)=Max{f(1)+p1,p2}
     * f(3)=Max{f(2)+p1,p3}
     * f(4)=Max{f(3)+p1,f(2)+p2,f(1)+p3}
     * ...
     * f(10)=Max{f(9)+p1,f(8)+p2,f(7)+p3}
     *
     * @param totalLength
     * @param values
     * @return
     */
    public static int cutForMaxValue1(int totalLength, int[] values) {
        if (totalLength == 0 || values == null || values.length == 0) {
            return 0;
        }
        int[] maxValues = new int[totalLength];
        if (values.length == 1) {
            return values[0];
        } else if (values.length == 2) {
            return Math.max(2 * values[0], values[2]);
        } else {
            maxValues[0] = values[0];
            maxValues[1] = Math.max(maxValues[0] + values[0], values[1]);
            maxValues[2] = Math.max(maxValues[1] + values[0], values[2]);
        }
        for (int i = 3; i < totalLength; i++) {
            maxValues[i] = Math.max(
                    Math.max(maxValues[i - 1] + values[0], maxValues[i - 2] + values[1]),
                    maxValues[i - 3] + values[2]);
        }
        return maxValues[totalLength - 1];
    }


    /**
     * 适用任意长度的数组
     *
     * @param totalLength
     * @param values
     * @return
     */
    public static int cutForMaxValue2(int totalLength, int[] values) {
        if (totalLength == 0 || values == null || values.length == 0) {
            return 0;
        }
        int[] maxValues = new int[totalLength];
        int valLength = values.length;
        for (int i = 0; i < totalLength; i++) {
            int maxValue = 0;
            if (i < valLength) {
                if (i == 0) {
                    maxValues[i] = values[0];
                } else {
                    maxValues[i] = Math.max(maxValues[i - 1] + values[0], values[i]);
                }
                continue;
            }

            for (int j = 0; j < valLength; j++) {
                int compareVal = maxValues[i - j - 1] + values[j];
                maxValue = Math.max(maxValue, compareVal);
            }
            maxValues[i] = maxValue;
        }
        return maxValues[totalLength - 1];
    }

    /**
     * 暴力法   要求给出所有的value，每一根所对应的价值
     * 自顶向下递归
     *
     * @param totalLength
     * @param values
     * @return
     */
    public static int cutForMaxValue3(int totalLength, int[] values) {
        if (totalLength <= 0) {
            return 0;
        } else {
            int profit = 0;
            for (int i = 0; i < totalLength; i++) {
                profit = Math.max(cutForMaxValue3(totalLength - i - 1, values) + values[i], profit);
            }
            return profit;
        }
    }

    /**
     * 带备忘的自顶向下递归实现
     *
     * @param totalLength
     * @param values
     * @return
     */
    public static int cutForMaxValue4(int totalLength, int[] values) {
        int[] results = new int[totalLength + 1];
        for (int i = 0; i <= totalLength; i++) {
            results[i] = 0;
        }
        return memorizedCutForMaxValue3(totalLength, values, results);
    }

    private static int memorizedCutForMaxValue3(int totalLength, int[] values, int[] results) {
        if (totalLength == 0) {
            return 0;
        }
        if (results[totalLength] > 0) {
            return results[totalLength];
        } else {
            int profit = 0;
            for (int i = 0; i < totalLength; i++) {
                profit = Math.max(cutForMaxValue3(totalLength - i - 1, values) + values[i], profit);
            }
            results[totalLength] = profit;
            return profit;
        }
    }
}