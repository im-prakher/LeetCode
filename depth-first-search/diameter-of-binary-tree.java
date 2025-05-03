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
    int diameter;
    public int solve(TreeNode root) {
        if(root == null)
            return 0;
        int lft = solve(root.left);
        int rht = solve(root.right);
        diameter = Math.max(diameter, lft + rht);
        return 1 + Math.max(lft, rht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        solve(root);
        return diameter;
    }
}