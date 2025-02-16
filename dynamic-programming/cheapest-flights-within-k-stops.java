class Solution {
    final int max = 10000_00000;
    public int dfs(int node, int dst, List<int[]> adj[], boolean[] vis, int k) {
        int res = max;
        if(k < 0)
            return res;
        if(node == dst)
            return 0;
        vis[node] = true;
        for(int[] vtx : adj[node]) {
            if(!vis[vtx[0]])
                res = Math.min(res, vtx[1] + dfs(vtx[0], dst, adj, vis, k-1));
        }
        return res;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]> adj[] = new List[n];
        for(int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();         
        for(int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        boolean vis[] = new boolean[n];
        int ans = dfs(src, dst, adj, vis, k+1);
        return ans >= max ? -1 : ans;
    }
}