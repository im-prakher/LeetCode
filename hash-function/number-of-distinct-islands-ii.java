class Solution {
    boolean valid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m; 
    }
    public boolean bfsDistinct(int[][] grid, int a, int b, Set<String> set) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{a, b});
        grid[a][b] = 0;
        int dir[] = {-1, 0, 1, 0, -1};
        int n = grid.length, m = grid[0].length;
        int max_i = 0, max_j = 0, min_i = n, min_j = m, area = 1;
        while(!que.isEmpty()) {
            int[] land = que.poll();
            int x = land[0], y = land[1];
            area++;
            min_i = Math.min(min_i, x);
            max_i = Math.max(max_i, x);
            min_j = Math.min(min_j, y);
            max_j = Math.max(max_j, y);
            for(int k = 0; k < 4; k++) {
                int nx = dir[k] + x, ny = dir[k+1] + y;
                if(valid(nx, ny, n, m) && grid[nx][ny] == 1) {
                    que.offer(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }
        String island = (max_i - min_i + 1) + "&" + (max_j - min_j + 1) + "&" + area;
        if(set.contains(island))
            return false;
        set.add(island);
        return true;
    }
    public int numDistinctIslands2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && bfsDistinct(grid, i, j, set))
                    cnt++;
            }
        }
        return cnt;
    }
}