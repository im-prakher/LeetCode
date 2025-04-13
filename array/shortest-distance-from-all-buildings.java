class Solution {
    void bfs(int i, int j, int n, int m, int[] dis, int[][] grid) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> b[2] - a[2]);
        que.offer(new int[]{i, j, 0});
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][m];
        vis[i][j] = true;
        while(!que.isEmpty()) {
            int[] node =  que.poll();
            for(int k = 0; k < 4; k++) {
                int p = node[0] + dx[k], q = node[1] + dy[k];
                if(p >= 0 && p < n && q >= 0 && q < m && grid[p][q] == 0 && !vis[p][q] && dis[p * m + q] > node[2]+1) {
                    dis[p * m + q] = node[2] + 1;
            vis[p][q] = true;
                    que.offer(new int[]{p, q, node[2]+1});
                }
            }   
        }
    }
    public int shortestDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] totDis = new int[n * m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int[] dis = new int[n*m];
                    bfs(i, j, n, m, dis, grid);
                    for(int k = 0; k < n * m; k++) {
                        if(dis[k]!=Integer.MAX_VALUE && totDis[k]!=-1)
                            totDis[k] += dis[k];
                        else totDis[k] = -1;
                    }
                }
            }
        }
        int ans= Integer.MAX_VALUE;
        for(int i = 0; i < n*m ; i++) {
            if(totDis[i]!=-1)
                ans = Math.min(ans, totDis[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}