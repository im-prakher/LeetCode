class Solution {
    int INF = (int)1e9;
    //Floyd-Warshall Algorithm
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }
        for(int[] edge: edges) {
            int i = edge[0], j = edge[1];
            adj[i][j] = edge[2];
            adj[j][i] = edge[2];
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        int ans = -1, min = n+1;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(adj[i][j] != INF && adj[i][j] <= distanceThreshold) 
                    cnt++;
            }
            if(cnt <= min) {
                ans = i; 
                min = cnt;
            }
        }
        return ans;
    }
}