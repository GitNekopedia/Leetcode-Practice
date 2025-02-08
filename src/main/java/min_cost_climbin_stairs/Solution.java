package min_cost_climbin_stairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 方法1： dp[i] 表示站在台阶 i（即已经支付了 cost[i]）后的最小累计花费
        // int n = cost.length;
        // if (n == 0) return 0;
        // if (n == 1) return cost[0];
        // int[] dp = new int[n];
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        // for (int i = 2; i < n; i++) {
        //     dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        // }
        // return Math.min(dp[n - 1], dp[n - 2]);

        // 方法2：dp[i] 表示到达第 i 个台阶时所花费的最小费用
        // dp[n] 为到达顶层所需的最小花费
        int n  = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];


    }
}