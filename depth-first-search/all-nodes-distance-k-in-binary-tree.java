/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, Integer> lvl = new HashMap<>();
    int fillLevel(TreeNode root, TreeNode target) {
        if(root == null)
            return -1;
        if(root == target) 
            return 0;
        int left = fillLevel(root.left, target);
        int right = fillLevel(root.right, target);
        int res = 1 + Math.max(left, right);
        if(left != -1 || right != -1) {
            lvl.put(root, res);
            return res;
        }
        return -1;
    }

    public void kthLevel(TreeNode root, int k, List<Integer> ans) {
        if(root == null || k < 0)
            return;
        if(k == 0) {
            ans.add(root.val);
            return;
        }
        if(!lvl.containsKey(root.left))
            kthLevel(root.left, k-1, ans);
        if(!lvl.containsKey(root.right))    
            kthLevel(root.right, k-1, ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        lvl.put(target, 0);
        fillLevel(root, target);
        List<Integer> ans = new ArrayList<>();
        for(var entry : lvl.entrySet()) {
            int abv = entry.getValue();;
            if(abv > k)
                continue;
            kthLevel(entry.getKey(), k - abv, ans);
        }
        return ans;
    }
}