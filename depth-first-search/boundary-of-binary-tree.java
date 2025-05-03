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
    List<Integer> travel;
    void addLeftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        travel.add(root.val);
        if(root.left != null)
            addLeftBoundary(root.left);
        else
            addLeftBoundary(root.right);
    }

    void addLeafNodes(TreeNode root) {
         if(root == null)
            return;
         if(root.left == null && root.right == null) {
            travel.add(root.val);
            return;
         }
         addLeafNodes(root.left);
         addLeafNodes(root.right);
    }

    void addRightBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.right != null)
            addRightBoundary(root.right);
        else
            addRightBoundary(root.left);
        travel.add(root.val);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        travel = new ArrayList<>();
        travel.add(root.val);
        addLeftBoundary(root.left);
        if(root.left != null || root.right!= null)
        addLeafNodes(root);
        addRightBoundary(root.right);
        return travel;
    }
}