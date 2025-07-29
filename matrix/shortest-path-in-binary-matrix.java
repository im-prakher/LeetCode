class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dx[] = {-1, 0, 1, 0, -1, -1, 1, 1};
        int dy[] = {0, 1, 0, -1, -1, 1, 1, -1};
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> a[0]- b[0]);
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 0)
            que.offer(new int[]{0,0,1});
        while(!que.isEmpty()) {
            int[] node = que.poll();
            int i = node[0], j = node[1], dis = node[2];
            if(i == n-1 && j == m-1)
                return node[2];
            for(int k = 0; k < 8; k++) {
                int nx = i + dx[k], ny = j + dy[k];
                if(nx >= 0 && nx< n && ny >= 0 && ny < m && grid[nx][ny]== 0) {
                    grid[nx][ny] = 1;
                    que.offer(new int[]{nx, ny, 1 + dis});
                }
            }
        }
        return -1;
    }
}