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

    public int rob(int[] nums) {
        Integer memo[] = new Integer[nums.length + 1];
        int ans = solve(nums, 0, memo);
        return ans;
    }
}
