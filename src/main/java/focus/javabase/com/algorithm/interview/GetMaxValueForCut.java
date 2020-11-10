
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

    private static void cut(int totalLength, int[] values, int idx, int total) {
        if (idx == values.length) {
            return;
        }

        if (totalLength == 0) {
            maxValue = Integer.max(maxValue, total);
            return;
        }
        //不包含1
        cut(totalLength, values, idx + 1, 0);

        if (totalLength >= idx + 1) {
            // 包含1
            cut(totalLength - idx - 1, values, idx, total + values[idx]);
        }
    }
}