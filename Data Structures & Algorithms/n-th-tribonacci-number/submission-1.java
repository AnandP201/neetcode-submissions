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
        return solve(n, new Integer[n + 1]);
    }
}