package focus.javabase.com.algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenjianrong-lhq
 * @Description gsx 机试题
 * @Date 2020-10-12 15:13
 **/
public class BalanceItem {

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0, 0, 0, 0, 0, 0};
        List<Integer> result = getAllBalanceItems(numbers);
        System.out.println(result);
    }

    public static List<Integer> getAllBalanceItems(int[] arrs) {
        if (arrs == null || arrs.length == 0 || arrs.length == 1) {
            return null;
        }
        // map存取前n项之和
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
            map.put(i, sum);
        }

        // 逐一遍历，判断下标元素是不是平衡点，即sum-f(i)==f(i-1)
        List<Integer> result = new ArrayList();
        for (int i = 1; i < arrs.length - 1; i++) {
            if (sum - map.get(i) == map.get(i - 1)) {
                result.add(arrs[i]);
            }
        }
        return result;
    }
}