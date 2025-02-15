package unique_paths_ii;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 如果起点有障碍，则无法出发
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 初始化第一列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            } else {
                // 前面无障碍，则可以到达
                dp[i][0] = (i == 0 ? 1 : dp[i - 1][0]);
            }
        }
        // 初始化第一行
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
            } else {
                dp[0][j] = (j == 0 ? 1 : dp[0][j - 1]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}