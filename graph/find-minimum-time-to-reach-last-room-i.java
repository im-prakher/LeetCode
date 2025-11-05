class Solution {
    //bfs similar to rotten oranges
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> a[2] - b[2]);
        que.offer(new int[]{0, 0, 0});
        int dx[] = {0, 1, 0, -1}; 
        int dy[] = {1, 0, -1, 0};
        int[][] time = new int[n][m];
        for(int[] row: time)
            Arrays.fill(row, Integer.MAX_VALUE);
        time[0][0] = 0;
        while(!que.isEmpty()) {
            int[] node = que.poll();
            int a = node[0], b = node[1], curTime = node[2];
            if(a == n-1 && b == m-1)
                return curTime;
            if(curTime > time[a][b])
                continue;
            for(int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m) {
                    int reach = Math.max(curTime, moveTime[x][y]) + 1;
                    if(reach < time[x][y]) {
                        time[x][y] = reach;
                        que.offer(new int[]{x, y, reach});
                    }
                }
            }

        }
        return -1;
    }
}