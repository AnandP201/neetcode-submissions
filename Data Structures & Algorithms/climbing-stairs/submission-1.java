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

    public int climbStairs(int n) {
        Integer memo[] = new Integer[n + 1];
        int ans = solve(n, memo);
        return ans;
    }
}
