class Solution {
    //bfs similar to rotten oranges
    public int minTimeToReach(int[][] moveTime) {
        int time = 0, n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> a[2] - b[2]);
        que.offer(new int[]{0, 0, 0});
        int dx[] = {0, 1, 0, -1}; 
        int dy[] = {1, 0, -1, 0};
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        while(!que.isEmpty()) {
            int[] node = que.poll();
            int a = node[0], b = node[1], curTime = node[2];
            if(a == n-1 && b == m-1)
                return curTime;
            for(int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
                    int reach = Math.max(curTime, moveTime[x][y]) + 1;;
                    que.offer(new int[]{x, y, reach});
                    vis[x][y] = true;
                }
            }

        }
        return -1;
    }
}