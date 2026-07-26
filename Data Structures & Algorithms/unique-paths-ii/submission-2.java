class Solution {
    public int dfs(int r, int c, int grid[][], Integer memo[][]) {
        if (r == grid.length || c == grid[0].length || grid[r][c] == 1)
            return 0;

        if (r == grid.length - 1 && c == grid[0].length - 1)
            return 1;

        if (memo[r][c] != null)
            return memo[r][c];

        return memo[r][c] = dfs(r + 1, c, grid, memo) + dfs(r, c + 1, grid, memo);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int dp[][] = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] += dp[r + 1][c];
                    dp[r][c] += dp[r][c + 1];
                }
            }
        }

        return dp[0][0];
    }
}