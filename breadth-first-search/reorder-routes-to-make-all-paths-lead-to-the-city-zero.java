class Solution {
    int cnt;
    public void dfs(Set<List<Integer>> set, int node, int par, List<Integer> adj[]) {
        for(int vtx : adj[node]) {
            if(par == vtx)
                continue;
            if(set.contains(List.of(node, vtx)))
                cnt++;
            dfs(set, vtx, node, adj);
        }
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
        cnt = 0;
        dfs(set, 0, -1, adj);
        return cnt;
    }
}