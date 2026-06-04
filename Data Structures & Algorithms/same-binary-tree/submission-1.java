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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> pdeq = new ArrayDeque<TreeNode>();
        Deque<TreeNode> qdeq = new ArrayDeque<TreeNode>();

        if (p == null) return q == null;
        if (q == null) return p == null;

        pdeq.push(p);
        qdeq.push(q);

        while(!pdeq.isEmpty()) {
            if (qdeq.isEmpty()) return false;

            TreeNode t1 = pdeq.pop();
            TreeNode t2 = qdeq.pop();
            if (((t1 == null ? 1 : 0) + (t2 == null ? 1 : 0)) == 1) return false;
            if (t1 != null && t2 != null) {
                if (t1.val != t2.val) return false;
                if (((t1.left == null ? 1 : 0) + (t2.left == null ? 1 : 0)) == 1) return false;
                if (t1.left != null) {
                    pdeq.push(t1.left);
                    qdeq.push(t2.left);
                }
                if (((t1.right == null ? 1 : 0) + (t2.right == null ? 1 : 0)) == 1) return false;
                if (t1.right != null) {
                    pdeq.push(t1.right);
                    qdeq.push(t2.right);
                }
            }
        }
        return qdeq.isEmpty();
    }
}
