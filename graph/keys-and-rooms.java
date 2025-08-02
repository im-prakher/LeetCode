class Solution {
    void dfs(List<List<Integer>> adj, Set<Integer> vis, int node) {
        vis.add(node);
        for(int vtx : adj.get(node)) {
            if(!vis.contains(vtx))
                dfs(adj, vis, vtx);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> vis = new HashSet<>();
        dfs(rooms, vis, 0);
        return vis.size() == rooms.size();
    }
}