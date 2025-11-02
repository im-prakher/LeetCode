class Solution {
    public boolean dfsCycle(int par, int node, List<Integer> adj[], boolean vis[]) {
        vis[node] = true;
        for(var vtx : adj[node]) {
            if(vtx == par)
                continue;
            if(vis[vtx])
                return true;
            else if(dfsCycle(node, vtx, adj, vis))
                return true;
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<Integer> adj[] = new List[n];
        for(int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i] && dfsCycle(-1, i, adj, vis))
                return false;
        }
        return true;
    }
}