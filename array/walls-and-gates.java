class Solution {
    public boolean valid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public void wallsAndGates(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0)
                    que.offer(new int[]{i, j});
            }
        }
        int dir[] = {-1, 0, 1, 0, -1};
        while(!que.isEmpty()) {
            int[] node = que.poll();
            for(int k = 0; k < 4; k++) {
                int x = node[0] + dir[k], y = node[1] + dir[k+1];
                if(valid(x, y, grid) && grid[x][y] == INF) {
                    grid[x][y] = 1 + grid[node[0]][node[1]];
                    que.offer(new int[]{x, y});
                }
            }
        }
    }
}