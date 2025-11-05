class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        que.offer(new int[]{0, 0, 0});
        int n = grid.length, m = grid[0].length;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        boolean[][] vis = new boolean[n][m];
        while(!que.isEmpty()) {
            int[] node = que.poll();
            int cost = node[0], a = node[1], b = node[2];
            vis[a][b] = true;
            if(a == n-1 && b == m-1)
                return cost;
            for(int k = 0; k < 4; k++) {
                int x = a + dx[k], y = b + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y]) {
                    int reach = cost + (grid[a][b] == k + 1 ? 0 : 1);
                    que.offer(new int[] {reach, x, y});
                }
            }
        }
        return -1;
    }
}