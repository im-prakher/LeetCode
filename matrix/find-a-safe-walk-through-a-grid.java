class Solution {
    Map<String, Boolean> memo;
    boolean[][] vis;
    public boolean traverse(List<List<Integer>> grid, int health, int i, int j) {
        if(i== 0 && j == 0) 
            return health > 0;
        if(i < 0 || i >= grid.size() ||
                 j < 0 || j >= grid.get(0).size() || health <= 0)
            return false;
        if(vis[i][j])
            return false;
        vis[i][j] = true;
        String key = i + "," + j + "," + health;
        if(memo.containsKey(key))
            return memo.get(key);
        health -= grid.get(i).get(j);
        boolean res =  traverse(grid, health , i-1, j)
                || traverse(grid, health, i, j-1) 
                || traverse(grid, health, i+1, j) 
                || traverse(grid, health, i, j+1);
        memo.put(key, res);
        return res;

    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        memo = new HashMap<>();
        vis = new boolean[grid.size()][grid.get(0).size()];
        return traverse(grid, health, grid.size() -1 , grid.get(0).size() - 1);
    }
}