class Solution {
    public int dfs(Set<List<Integer>> set, int node, int par, List<Integer> adj[]) {
        int cnt = 0;
        for(int vtx : adj[node]) {
            if(par == vtx)
                continue;
            if(set.contains(List.of(node, vtx)))
                cnt++;
            cnt += dfs(set, vtx, node, adj);
        }
        return cnt;
    }

    public int minReorder(int n, int[][] connections) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> adj[] = new List[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] conc : connections) {
            set.add(List.of(conc[0], conc[1]));
            adj[conc[0]].add(conc[1]);
            adj[conc[1]].add(conc[0]);
        }
        return dfs(set, 0, -1, adj);
    }
}