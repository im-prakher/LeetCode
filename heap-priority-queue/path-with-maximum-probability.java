class Solution {
    final double min = 0.0;
    public record Node(int val, double wt){}

    public double maxPath(int node, int end, List<Node> adj[], boolean[] vis) {
        if(node == end)
            return 1.0;
        vis[node] = true;
        double res = min;
        for(var vtx : adj[node]) {
            if(!vis[vtx.val])
                res = Math.max(res, vtx.wt * maxPath(vtx.val, end, adj, vis));
        }
        return res;
    }

    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        List<Node> adj[] = new List[n];
        boolean[] vis = new boolean[n];
        for(int i= 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Node(edges[i][1], prob[i]));
            adj[edges[i][1]].add(new Node(edges[i][0], prob[i]));
        }
        return maxPath(start, end, adj, vis);
    }
}