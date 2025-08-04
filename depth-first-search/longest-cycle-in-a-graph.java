class Solution {
    public int dfs(int node, int len, int[] cyc, boolean[] vis, int[] edges) {
        if(cyc[node] != -1)
            return len - cyc[node] + 1; 
        if(vis[node])
            return -1;
        int vtx = edges[node];
        vis[node] = true;
        if(vtx == -1)
            return -1;
        cyc[node] = ++len;
        int ans = dfs(vtx, len, cyc, vis, edges);
        cyc[node] = -1;
        return ans;
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] cyc = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(cyc, -1);
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ans = Math.max(ans, dfs(i, 0, cyc, vis, edges));
            }
        }
        return ans;
    }
}