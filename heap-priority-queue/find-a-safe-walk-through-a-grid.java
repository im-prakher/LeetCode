class Solution {
    Map<String, Boolean> memo;
    int[][] vis;
    public boolean traverse(List<List<Integer>> grid, int health, int i, int j) {
        
        if(i < 0 || i >= grid.size() ||
                 j < 0 || j >= grid.get(0).size())
            return false;
        health -= grid.get(i).get(j);
        if (health <= 0) return false;
        if(i== 0 && j == 0) 
            return true;
        if(vis[i][j] >= health)
            return false;
        vis[i][j] = health;
        boolean res =  traverse(grid, health , i-1, j)
                || traverse(grid, health, i, j-1) 
                || traverse(grid, health, i+1, j) 
                || traverse(grid, health, i, j+1);
        return res;

    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        memo = new HashMap<>();
        vis = new int[grid.size()][grid.get(0).size()];
        return traverse(grid, health, grid.size() -1 , grid.get(0).size() - 1);
    }
}