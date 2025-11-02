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
    public boolean travel(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return subRoot == null;
        if(subRoot != null && root.val == subRoot.val)
            return travel(root.left, subRoot.left)
                    && travel(root.right, subRoot.right);
        subRoot = sub;
        return travel(root.left, subRoot) || travel(root.right, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        sub = subRoot;
        return travel(root, subRoot);
    }
}