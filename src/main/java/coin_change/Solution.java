package coin_change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}