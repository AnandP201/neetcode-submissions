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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append("# ");
                continue;
            }

            sb.append(curr.val + " ");

            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;

        String[] arr = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        q.add(root);

        for (int i = 1; i < arr.length - 1; i++) {
            TreeNode parent = q.poll();

            if (!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.add(left);
            }

            if (!arr[i + 1].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i + 1]));
                parent.right = right;
                q.add(right);
            }
            
            i++;
        }

        return root;
    }
}
