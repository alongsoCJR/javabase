package focus.javabase.com.leetcode;


import java.util.HashMap;
import java.util.Map;

//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//
//每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//
//您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
//
//示例 1:
//
//输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
//
public class MinCostClimbingStairsT746 {

    public static int minCostClimbingStairs(int[] cost) {
        return minCost(cost, cost.length - 1);
    }


    // 性能很差，超时
    public static int minCost(int[] cost, int index) {

        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return Integer.min(cost[0], cost[1]);
        }

        return Integer.min(cost[index] + minCost(cost, index - 1),
                cost[index - 1] + minCost(cost, index - 2));
    }


    public static int minCostClimbingStairs0(int[] cost) {
        int size = cost.length;
        int[] minCost = new int[size];
        minCost[0] = 0;
        minCost[1] = Integer.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            minCost[i] = Integer.min(cost[i - 1] + minCost[i - 2], cost[i] + minCost[i - 1]);
        }
        return minCost[size - 1];
    }

    public static int minCostClimbingStairs1(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = cost.length;
        int[] minCost = new int[size];
        map.put(0, 0);
        map.put(1, Integer.min(cost[0], cost[1]));
        for (int i = 2; i < size; i++) {
            int val = Integer.min(cost[i - 1] + map.get(i - 2), cost[i] + map.get(i - 1));
            map.put(i, val);
        }
        return map.get(size - 1);
    }


    public static int minCostClimbingStairs2(int[] cost) {
        int size = cost.length;
        int cost0 = 0;
        int cost1 = Integer.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            int val = Integer.min(cost[i - 1] + cost0, cost[i] + cost1);
            cost0 = cost1;
            cost1 = val;

        }
        return cost1;
    }

}