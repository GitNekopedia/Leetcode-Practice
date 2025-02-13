package target_sum;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0 || target > sum) return 0;
        int m = (sum - target) / 2;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = m; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[m];


        // int[][] dp = new int[n + 1][m + 1];
        // dp[0][0] = 1;
        // for (int i = 1; i <= n; i++){
        //     int x = nums[i - 1];
        //     for (int j = 0; j <= m; j++){
        //         int no = dp[i-1][j];
        //         int yes = j >= x ? dp[i-1][j-x] : 0;
        //         dp[i][j] = no + yes;
        //     }
        // }
        // return dp[n][m];

    }
}