class Solution {
    int dir[] = { -1, 0, 1, 0, -1 };
    char[] sign = {'U', 'R', 'D', 'L'};
    boolean valid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

    public void dfsDistinct(int[][] grid, int x, int y, StringBuilder island) {
        grid[x][y] = 0;
        int n = grid.length, m = grid[0].length;
        for (int k = 0; k < 4; k++) {
            int nx = dir[k] + x, ny = dir[k + 1] + y;
            if (valid(nx, ny, n, m) && grid[nx][ny] == 1) {
                island.append(sign[k]);
                dfsDistinct(grid, nx, ny, island);
                island.append("B");
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder island = new StringBuilder();
                    island.append("O");
                    dfsDistinct(grid, i, j, island);
                    set.add(island.toString());
                }
            }
        }
        return set.size();
    }
}