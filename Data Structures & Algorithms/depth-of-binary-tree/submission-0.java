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
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        if (root == null) return 0;
        stack.push(root);
        st2.push(1);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int n = st2.pop();
            if (node != null) {
                res = Math.max(res, n);
                if (node.left != null) {
                    stack.push(node.left);
                    st2.push(n + 1);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    st2.push(n + 1);
                }
            }
        }
        return res;
    }
}
