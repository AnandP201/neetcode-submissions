class Solution {
    public int solve(int nums[], int idx, Integer memo[]) {
        if (idx >= nums.length)
            return 0;

        if (memo[idx] != null)
            return memo[idx];

        int skip = solve(nums, idx + 1, memo);

        int pick = nums[idx] + solve(nums, idx + 2, memo);

        return memo[idx] = Math.max(skip, pick);
    }

    int solveDP(int nums[]) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int dp[] = new int[nums.length + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        // Integer memo[] = new Integer[nums.length + 1];
        // int ans = solve(nums, 0, memo);

        int ans = solveDP(nums);
        return ans;
    }
}
