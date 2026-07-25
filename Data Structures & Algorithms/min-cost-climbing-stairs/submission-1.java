class Solution {
    public int solve(int idx, int n, int cost[], Integer memo[]) {
        if (idx >= n)
            return 0;

        if (memo[idx] != null)
            return memo[idx];

        return memo[idx] = cost[idx]
            + Math.min(solve(idx + 1, n, cost, memo), solve(idx + 2, n, cost, memo));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer memo[] = new Integer[n + 1];
        return Math.min(solve(0, n, cost, memo), solve(1, n, cost, memo));
    }
}
