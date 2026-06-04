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
    public boolean isBalanced(TreeNode root) {
        return recFunc(root)[1] == 1;
    }

    public int[] recFunc(TreeNode node) {
        if (node == null) return new int[] {0, 1};
        int[][] res = new int[][] {recFunc(node.left), recFunc(node.right)};
        if (res[0][1] == 0 || res[1][1] == 0) return new int[] {0, 0};
        return new int[] { 1 + Math.max(res[0][0], res[1][0]), Math.abs(res[0][0] - res[1][0]) <= 1 ? 1 : 0 };
    }
}
