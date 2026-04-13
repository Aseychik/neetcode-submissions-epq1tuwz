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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return null;
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if(t != null) {
                TreeNode t2 = t.left;
                t.left = t.right;
                t.right = t2;
                if (t.left != null)
                    stack.push(t.left);
                if (t.right != null)
                    stack.push(t.right);
            }
        }
        return root;
    }
}
