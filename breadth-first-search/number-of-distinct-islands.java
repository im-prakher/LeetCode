class Solution {
    boolean valid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

    public StringBuilder bfsDistinct(int[][] grid, int x, int y, int a, int b) {
        grid[x][y] = 0;
        int dir[] = { -1, 0, 1, 0, -1 };
        int n = grid.length, m = grid[0].length;
        StringBuilder island = new StringBuilder();
        island.append((x - a) + "&" + (y - b) + "&");
        for (int k = 0; k < 4; k++) {
            int nx = dir[k] + x, ny = dir[k + 1] + y;
            if (valid(nx, ny, n, m) && grid[nx][ny] == 1) {
                island.append(bfsDistinct(grid, nx, ny, a, b));
            }
        }
        return island;
    }

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    set.add(bfsDistinct(grid, i, j, i, j).toString());
            }
        }
        return set.size();
    }
}