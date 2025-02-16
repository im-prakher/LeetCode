class Solution {
    int idx;
    public boolean dfsTopo(int[] ans, int node, List<Integer> adj[], boolean vis[], boolean pathVis[]) {
        vis[node] = true;
        pathVis[node] = true;
        boolean res = false;
        for(int vtx : adj[node]) {
            if(!vis[vtx])
                res = dfsTopo(ans, vtx, adj, vis, pathVis);
            else if(pathVis[vtx])
                return true;
        }
        pathVis[node] = false;
        ans[idx--] = node;
        return res;
    }

    public int[] findOrder(int n, int[][] preq) {
        idx = n-1;
        int[] ans = new int[n];
        List<Integer> adj[] = new List[n];
        // Arrays.fill(adj, new ArrayList<>());--> will fill each adj[i] with same list reference so don't use as insertion at one index will insert at all indexes
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : preq)  {
            adj[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i] && dfsTopo(ans, i, adj, vis, pathVis))
                return new int[0];
        }
        return ans;  
    }
}