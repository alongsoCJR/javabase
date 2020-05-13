package focus.javabase.com.leetcode;

public class MaxProfitT122 {


    // 暴力法  7, 1, 5, 3, 6, 4
    public static int maxProfit(int[] prices) {
        return calMaxProfit(prices, 0);
    }

    /**
     * @return int
     * @Author chenjianrong-lhq
     * @Description 遍历
     * @Date 2020-05-13 13:20
     * @Param [prices, len]
     **/
    private static int calMaxProfit(int[] prices, int s) {
        if (s > prices.length) {
            return 0;
        }
        int max = 0;
        for (int size = s; size < prices.length; size++) {
            int maxProfit = 0;
            for (int i = size + 1; i < prices.length; i++) {
                if (prices[i] > prices[size]) {
                    int profit = calMaxProfit(prices, i + 1) + prices[i] - prices[size];

                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }

        }

        return max;
    }


    // 参考
    public static int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

}