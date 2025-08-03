class Solution {
    public int dfs(int node, int par, List<List<Integer>> adj[]) {
        int cnt = 0;
        for(var vtx : adj[node]) {
            if(par == vtx.get(0))
                continue;
            cnt += dfs(vtx.get(0), node, adj) + vtx.get(1);
        }
        return cnt;
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj[] = new List[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] conc : connections) {
            adj[conc[0]].add(List.of(conc[1], 1));
            adj[conc[1]].add(List.of(conc[0], 0));
        }
        return dfs(0, -1, adj);
    }
}