package ones_and_zeros;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示在最多有 i 个 0 和 j 个 1 的情况下，最多能选取的字符串个数
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            // 统计当前字符串中 0 和 1 的个数
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            // 倒序遍历，确保每个字符串只用一次
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}