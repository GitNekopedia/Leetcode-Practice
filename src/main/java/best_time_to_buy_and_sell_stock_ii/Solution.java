package best_time_to_buy_and_sell_stock_ii;

class Solution {
    public int maxProfit(int[] prices) {
        // 贪心算法
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff >0){
                // 股票价格上涨
                maxProfit += diff;
            }
        }
        return maxProfit;

        // // 动态规划
        // int len = prices.length;
        // if (len < 2){
        //     return 0;
        // }
        // int[][] dp = new int[len][2];
        // // 持有现金
        // dp[0][0] = 0;
        // // 持有股票
        // dp[0][1] = -prices[0];
        // for (int i = 1; i < len; i++) {
        //     // 当前持有现金可能是前一天持有现金或者前一天持有股票今天卖出
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     // 当前持有股票可能是前一天持有股票或者前一天持有现金今天买入
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // }
        // return dp[len - 1][0];
    }
}