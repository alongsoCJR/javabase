package focus.javabase.com.leetcode;

public class MaxProfitT121 {


    // 先买后卖，买的钱必须小于卖的钱  时间复杂读O(n^2)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && prices[j] > prices[i]; j++) {
                maxProfit = Integer.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }


    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProfit = Integer.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }
}