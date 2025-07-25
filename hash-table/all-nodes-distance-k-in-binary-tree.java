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

    public void kthLevel(TreeNode root, int k, Set<Integer> set) {
        if(root == null || k < 0)
            return;
        if(k == 0 && !lvl.containsKey(root)) {
            set.add(root.val);
            return;
        }
        kthLevel(root.left, k-1, set);
        kthLevel(root.right, k-1, set);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        lvl.put(target, 0);
        fillLevel(root, target);
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(var entry : lvl.entrySet()) {
            int abv = entry.getValue();
            TreeNode node = entry.getKey();
            if(abv == k)
                set.add(node.val);
            if(abv >= k)
                continue;
            kthLevel(node, k - abv, set);
        }
        return new ArrayList<>(set);
    }
}