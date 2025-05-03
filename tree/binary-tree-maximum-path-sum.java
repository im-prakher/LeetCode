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
    int mps;
    public int compute(TreeNode root) {
        if(root == null )
            return 0;
        int left = compute(root.left);
        int right = compute(root.right);
        int path = Math.max(Math.max(left, right), 0) + root.val;
        mps = Math.max(mps, Math.max(path, left + root.val + right));
        return path;
    }

    public int maxPathSum(TreeNode root) {
        mps = root.val;
        compute(root);
        return mps;
    }
}