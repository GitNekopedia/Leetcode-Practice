package combination_sum_iv;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;  // 凑成金额 0 的组合数是 1（空组合）

        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }

        return dp[target];
    }
}