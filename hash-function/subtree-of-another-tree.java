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
    TreeNode sub;
    public boolean match(TreeNode a, TreeNode b) {
        if(a == null || b == null)
            return a == b;
        return a.val == b.val && match(a.left, b.left)
                && match(a.right, b.right);
        
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(match(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}