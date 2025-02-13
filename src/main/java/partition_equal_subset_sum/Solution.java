package partition_equal_subset_sum;

import java.util.Arrays;


class Solution {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // boolean[][] dp = new boolean[length + 1][target + 1];
        // // 初始化
        // dp[0][0] = true;
        //
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 0; j < dp[i].length; j++) {
        //         int num = nums[i - 1];
        //         if (j < num) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             // j >= num
        //             dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
        //         }
        //     }
        // }
        // return dp[length][target];

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {

            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }

        }
        return dp[target];

    }
}