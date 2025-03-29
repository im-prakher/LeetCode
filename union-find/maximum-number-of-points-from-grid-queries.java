class Solution{
    class Node{
        int x, y, cost;
        Node(){ 
            x = y = cost = -1;
        }
        Node(int i, int j, int c) {
            x = i; y = j; cost = c;
        }
    }
    public int[][] bfsCost(int[][] grid, int n, int m) {
        int[][] cost = new int[n][m];
        for(int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.cost - b.cost);
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        pq.offer(new Node(0, 0, grid[0][0]));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.x, j = node.y;
            if(cost[i][j] != Integer.MAX_VALUE)
                continue;
            cost[i][j] = Math.max(grid[i][j], node.cost);
            for(int k = 0; k < 4; k++) {
                int x = i + dx[k], y = j + dy[k];
                if(x >= 0 && x < n && y >= 0 && y < m 
                    && cost[x][y] == Integer.MAX_VALUE) {
                        pq.offer(new Node(x ,y, cost[i][j]));
                    }
            }
        }
        return cost;
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int[][] cost = bfsCost(grid, n, m);
        int[] freq = new int[1000_002];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                freq[cost[i][j]+1]++;
            }
        }
        for(int i = 2; i < freq.length; i++) {
            freq[i] += freq[i-1];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = freq[queries[i]];
        }
        return ans;
    }
}