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

    // 参考  {7, 1, 5, 3, 6, 4}
    public static int maxProfit1(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }

    //              7,1,5,3,6,4
    //maxProfit  0  0 0 4 4 5 5
    //minVal     +& 7 1 1 1 1 1
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > minVal) {
                maxProfit = Math.max(maxProfit, prices[i] - minVal);
            }
            minVal = Math.min(minVal, prices[i]);
        }
        return maxProfit;
    }
}