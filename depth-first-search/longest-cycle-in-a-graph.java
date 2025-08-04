class Solution {
    public int dfs(int node, int[] cyc, int[] edges) {
        int vtx = edges[node];
        if(vtx == -1)
            return -1;
        int ans = -1;
        if(cyc[vtx] != -1)
            return cyc[node] - cyc[vtx] + 1;
        cyc[vtx] = cyc[node] + 1;
        ans = Math.max(ans, dfs(vtx, cyc, edges));
        return ans;
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] cyc = new int[n];
        Arrays.fill(cyc, -1);
        cyc[0] = 0;
        return dfs(0, cyc, edges);
    }
}