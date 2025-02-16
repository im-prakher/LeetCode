class Solution {
    int idx;
    public void dfsTopo(int[] ans, int node, List<Integer> adj[], boolean vis[]) {
        vis[node] = true;
        for(int vtx : adj[node]) {
            if(!vis[vtx])
                dfsTopo(ans, vtx, adj, vis);
        }
        ans[idx--] = node;
    }

    public int[] findOrder(int n, int[][] preq) {
        idx = n-1;
        int[] ans = new int[n];
        List<Integer> adj[] = new List[n];
        Arrays.fill(adj, new ArrayList<>());
        for(int[] edge : preq)  {
            adj[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i])
                dfsTopo(ans, i, adj, vis);
        }
        return ans;  
    }
}