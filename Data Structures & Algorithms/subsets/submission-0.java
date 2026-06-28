class Solution {
    void backtrack(int[] nums, int idx, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
}
