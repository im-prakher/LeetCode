class Solution {
    public void dfsVis(int node, Map<Integer, List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int vtx : adj.get(node)) {
            if(!vis[vtx])
                dfsVis(vtx, adj, vis);
        }
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean vis[] = new boolean[n];
        for(int i =0; i < n; i++)
            adj.put(i, new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                components++;
                dfsVis(i, adj, vis);
            }
        }
        return components;
    }
}