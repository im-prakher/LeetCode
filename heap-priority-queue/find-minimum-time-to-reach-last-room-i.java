class Solution {
    //bfs similar to rotten oranges
    // public int bfsTime(int[][] moveTime, int i, int j) {
    // }

    public int minTimeToReach(int[][] moveTime) {
        int time = 0, n = moveTime.length, m = moveTime[0].length;
        // return bfsTime(moveTime, 0, 0);
        PriorityQueue<int[]> que = new PriorityQueue<>(
            (a, b)-> moveTime[a[0]][a[1]] != moveTime[b[0]][b[1]] ? moveTime[a[0]][a[1]] - moveTime[b[0]][b[1]] : b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        que.offer(new int[]{0, 0});
        int dx[] = {0, 1, 0, -1}; 
        int dy[] = {1, 0, -1, 0};
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        while(!que.isEmpty()) {
            int[] node = que.poll();
            int a = node[0], b = node[1];
            if(a != 0 || b != 0)
                time = Math.max(time, moveTime[a][b]) + 1;
            for(int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
                    if(x == n-1 && y == m-1)
                        return Math.max(time, moveTime[x][y]) + 1;;
                    que.offer(new int[]{x, y});
                    vis[x][y] = true;
                }
            }

        }
        return time;
    }
}