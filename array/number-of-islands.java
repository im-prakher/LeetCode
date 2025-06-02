class Solution {
    public void bfsExplore(int i, int j, char[][] grid, int n, int m) {
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '0'; // Mark visited

        while (!q.isEmpty()) {
            int[] land = q.poll();
            int r = land[0], c = land[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != '1')
                    continue;

                q.offer(new int[]{nr, nc});
                grid[nr][nc] = '0'; // Mark visited
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0, n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    bfsExplore(i, j, grid, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}
