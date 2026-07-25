class Solution {
    public int solve(int n, Integer memo[]) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (memo[n] != null)
            return memo[n];

        return memo[n] = solve(n - 2, memo) + solve(n - 1, memo);
    }

    public int solveDP(int n) {
        if (n <= 2)
            return n;
        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        // Integer memo[] = new Integer[n + 1];
        // int ans = solve(n, memo);
        // return ans;

        int ans = solveDP(n);
        return ans;
    }
}
