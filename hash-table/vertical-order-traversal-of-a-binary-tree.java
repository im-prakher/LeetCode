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
    static class Pair implements Comparable<Pair>{
    int lvl;
    int val;
    Pair(){
        lvl = val =0;
    }
    Pair(int lvl, int val){
        this.lvl = lvl;
        this.val =val;
    }
    
    @Override
    public int compareTo(Pair p) {
        return this.val - p.val;
    }
    
    }
    //hlv-> columns left to right
    //lvl-> up to down
    static void helper(TreeNode root, Map<Integer, TreeSet<Integer>> mp, int hlv, int lvl){
        if(root == null)
            return;
        if(mp.containsKey(hlv)){
            TreeSet<Integer> list = mp.get(hlv);
            list.add(root.val);
            mp.put(hlv, list);
        } else {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(root.val);
            mp.put(hlv, set);
        }
        helper(root.left, mp, hlv-1, lvl+1);
        helper(root.right, mp, hlv+1, lvl+1);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeSet<Integer>> mp = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, mp, 0, 0);
        for(Integer key : mp.keySet()){
            ans.add(new ArrayList<>(mp.get(key)));
        }
        return ans;
    }
}