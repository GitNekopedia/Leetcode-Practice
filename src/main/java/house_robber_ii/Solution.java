package house_robber_ii;

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }

    private int rob(int[] nums, int start, int end) {

        if (start == end) return nums[start];
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i <= end - start; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[dp.length - 1];
    }
}