class Solution {
    boolean valid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m; 
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 1});
        int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0}, dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        grid[0][0] = 1;
        int n = grid.length, m = grid[0].length;
        while(!que.isEmpty()) {
            int arr[] = que.poll();
            int x = arr[0], y = arr[1], dist = arr[2];
            if(x == n-1 && y == m-1)
                return dist;
            for(int k = 0; k < 8; k++) {
                int nx = dx[k] + x, ny = dy[k] + y;
                if(valid(nx, ny, n, m) && grid[nx][ny] == 0) {
                    que.offer(new int[]{nx, ny, dist + 1});
                    grid[nx][ny] = 1;
                }
            }
        }
        return -1;
    }
}