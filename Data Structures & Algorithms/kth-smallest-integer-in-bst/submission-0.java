/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    void dfs(TreeNode node, int k, int ans[], int level[]) {
        if (node == null)
            return;

        dfs(node.left, k, ans, level);

        if (level[0]++ == k - 1) {
            ans[0] = node.val;
            return;
        }
        dfs(node.right, k, ans, level);
    }

    public int kthSmallest(TreeNode root, int k) {
        int ans[] = new int[1];
        int level[] = new int[1];

        dfs(root, k, ans, level);
        return ans[0];
    }
}
