class Solution {
    int[] bdx, adx;
    //to root
    public boolean dfsBob(Integer node, List<Integer> adj[], int pos, int par, int n) {
        bdx[node] = pos;
        if(node == 0)
            return true;
        else if(adj[node].isEmpty()) {
            bdx[node] = 0;
            return false;
        }
        for(int vtx : adj[node]) {
            if(vtx!= par && dfsBob(vtx, adj, pos+1, node, n))
                return true;
        }
        bdx[node] = n+1;
        return false;
    }
    // to leaf
    public int dfsAlice(Integer node, List<Integer> adj[], int pos, int amt[], int par) {
        adx[node] = pos;
        int gate = 0;
        if(adx[node] < bdx[node])
            gate = amt[node];
        else if(adx[node] == bdx[node])
            gate = amt[node] / 2;
        if(adj[node].isEmpty())
            return gate;
        int cost = Integer.MIN_VALUE / 10;
        for(int vtx : adj[node]) {
            if(vtx != par)
                cost = Math.max(cost, dfsAlice(vtx, adj, pos+1, amt, node));
        }
        return gate + (cost == Integer.MIN_VALUE/10 ? 0 : cost);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer> adj[] = new List[n];
        for(int i = 0; i < n ; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add((edge[1]));
            adj[edge[1]].add(edge[0]);
        }
        bdx = new int[n]; adx = new int[n];
        Arrays.fill(bdx, n+1);
        dfsBob(bob, adj,1, -1, n);
        return dfsAlice(0, adj, 1, amount, -1);
    }
}