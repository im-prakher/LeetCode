class Solution {
    boolean valid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m; 
    }
    public void bfsDistinct(int[][] grid, int a, int b, Set<String> set) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{a, b});
        grid[a][b] = 0;
        int dir[] = {-1, 0, 1, 0, -1};
        int n = grid.length, m = grid[0].length;
        StringBuilder island = new StringBuilder();
        while(!que.isEmpty()) {
            int[] land = que.poll();
            int x = land[0], y = land[1];
            island.append((x-a) + "&" + (y-b) + "&");
            for(int k = 0; k < 4; k++) {
                int nx = dir[k] + x, ny = dir[k+1] + y;
                if(valid(nx, ny, n, m) && grid[nx][ny] == 1) {
                    que.offer(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }
        set.add(island.toString());
    }
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                 bfsDistinct(grid, i, j, set);
            }
        }
        return set.size();
    }
}