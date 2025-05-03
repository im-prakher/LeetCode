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
    public TreeNode[] flat(TreeNode root) {        
        if(root == null || (root.left == null && root.right == null))
            return new TreeNode[]{root, root};
        TreeNode[] nex = flat(root.right);
        TreeNode[] left = flat(root.left);
        root.right = left[0];
        left[1].right = nex[0];
        return new TreeNode[]{root, nex[1]};
    }
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left!= null) {
            flatten(root.left);
            TreeNode curr = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) {
                root = root.right;
            }
            root.right = curr;
        }
         flatten(root.right);
    }
}