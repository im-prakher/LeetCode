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
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
    public TreeNode lca(TreeNode root, int depth) {
        if(root == null || depth == 0)
            return root;
        TreeNode left = lca(root.left, depth-1);
        TreeNode right = lca(root.right, depth-1);
        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = height(root);
        return lca(root, depth-1);
    }
}