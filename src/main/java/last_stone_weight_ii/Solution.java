package last_stone_weight_ii;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - 2 * dp[target];



        // int[][] dp = new int[n][target + 1];
        // for (int j = 0; j <= target; j++) {
        //     dp[0][j] = j >= stones[0] ? stones[0] : 0;
        // }
        // for (int i = 1; i < n; i ++) {
        //     int t = stones[i];
        //     for (int j = 0; j <= target; j++) {
        //         int no = dp[i - 1][j];
        //         int yes = j >= t ? t + dp[i - 1][j - t] : 0;
        //         dp[i][j] = Math.max(yes, no);
        //     }
        // }
        // return sum - 2 * dp[n - 1][target];






    }
}