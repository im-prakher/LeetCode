class Solution {
    int diameter = 0;
    public int dfsPath(int node, int par, Map<Integer, List<Integer>> adj) {
        int max = 0, smax = 0;
        for(int vtx : adj.get(node)) {
            if(par != vtx) {
                int path = 1 + dfsPath(vtx, node, adj);
                if(path >= max) {
                    smax = max;
                    max = path;
                } else if(path > smax)
                    smax = path;
            }
        }
        diameter = Math.max(diameter, smax + max);
        return max;
    }
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfsPath(0, -1, adj);
        return diameter;
    }
}