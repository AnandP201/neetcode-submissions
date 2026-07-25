class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }

        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
