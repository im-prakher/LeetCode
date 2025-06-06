class Solution {
    public void dfs(int x, int y, int[][] grid, int dist) {
        if (grid[x][y] == -1)
            return;
        int n = grid.length, m = grid[0].length;
        grid[x][y] = dist;
        if (x - 1 >= 0 && grid[x - 1][y] > dist + 1)
            dfs(x - 1, y, grid, dist + 1);
        if (y + 1 < m && grid[x][y + 1] > dist + 1)
            dfs(x, y + 1, grid, dist + 1);
        if (x + 1 < n && grid[x + 1][y] > dist + 1)
            dfs(x + 1, y, grid, dist + 1);
        if (y - 1 >= 0 && grid[x][y - 1] > dist + 1)
            dfs(x, y - 1, grid, dist + 1);
    }

    public void wallsAndGates(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    dfs(i, j, grid, 0);
            }
        }
    }
}