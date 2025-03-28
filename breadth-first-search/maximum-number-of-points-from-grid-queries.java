class Solution {
    public class Node {
        int x, y;
        Node(int i, int j) {
            x = i; y = j;
        }
        Node() {
            x = -1; y = -1;
        }
    }

    public int bfs(int[][] cost, int query) {
        int n = grid.length, m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> b.dist - a.dist);
        pq.offer(new Node(0, 0, grid[0][0]));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.x, j = node.y;
            if(cost[i][j] < query)
                cnt++;
            for(int k = 0; k < 4; k++) {
                int xn = i + dx[k], yn = j + dy[k];
                if(xn >= 0 && xn < n && yn >= 0 && yn < m && cost[xn][yn] < query) 
                    pq.offer(new Node(xn, yn));
            }
        }
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int freq[] = new int[1000_001];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                freq[cost[i][j]]++;
            }
        }
        for(int i = 1; i < freq.length; i++) {
            freq[i] += freq[i-1];
        }
        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = freq[queries[i]];
        }
        return ans;
    }
}