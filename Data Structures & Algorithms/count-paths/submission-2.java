class Solution {
    public int solve(int m, int n, int r, int c, Integer memo[][]) {
        // we reached end cell
        if (r == m - 1 && c == n - 1)
            return 1;

        if (r >= m || c >= n)
            return 0;

        if (memo[r][c] != null)
            return memo[r][c];

        return memo[r][c] = solve(m, n, r + 1, c, memo) + solve(m, n, r, c + 1, memo);
    }

    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];

        // for (int c = 0; c < n; c++) {
        //     dp[0][c] = 1;
        // }

        // for (int r = 0; r < m; r++) {
        //     dp[r][0] = 1;
        // }

        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }

        // return dp[m - 1][n - 1];

        Integer memo[][] = new Integer[m + 1][n + 1];

        int ans = solve(m, n, 0, 0, memo);
        return ans;
    }
}
