class Solution {
    final double max = 1000_00.0;
    public record Node(int val, double wt){}

    public double maxPath(int node, int end, List<Node> adj[], boolean[] vis) {
        if(node == end)
            return 0.0;
        vis[node] = true;
    }

    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        List<Node> adj[] = new List[n];
        boolean[] vis = new boolean[n];
        for(int i= 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj[edge[i][0]].add(new Node(edge[i][1], prob[i]));
            adj[edge[i][1]].add(new Node(edge[i][0], prob[i]));
        }
        return maxPath(start, end, edges, adj, vis);
    }
}