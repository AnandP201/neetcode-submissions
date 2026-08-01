class Solution {
    public int solve(int n, Integer memo[]) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        if (memo[n] != null)
            return memo[n];

        return memo[n] = solve(n - 3, memo) + solve(n - 2, memo) + solve(n - 1, memo);
    }

    public int tribonacci(int n) {
        if (n <= 2) 
            return n == 0 ? 0 : 1;
        

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}