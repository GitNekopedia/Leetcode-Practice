package coin_change_ii;

class Solution {
    public int change(int amount, int[] coins) {
        // 一维数组做法
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];

        // // 二维数组做法
        // int n = coins.length;
        // int[][] dp = new int[n + 1][amount + 1];
        //
        // // 初始化
        // dp[0][0] = 1;
        //
        // for (int i = 1; i <= n; i++) {
        //     int val = coins[i - 1];
        //     for (int j = 0; j <= amount; j++) {
        //         // 不选当前硬币
        //         dp[i][j] = dp[i - 1][j];
        //
        //         // 选当前硬币
        //         if (j >= val){
        //             dp[i][j] += dp[i][j -val];
        //         }
        //     }
        //
        // }
        // return dp[n][amount];
    }
}