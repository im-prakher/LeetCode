class Solution {
    public void dfsTopo(int node, boolean vis[], List<Integer> adj[], BitSet prqDp[]) {
        vis[node] = true;
        for(int vtx : adj[node]) {
            prqDp[vtx].set(node);
            prqDp[vtx].or(prqDp[node]);
            // if(!vis[vtx])
                dfsTopo(vtx, vis, adj, prqDp);
        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] queries) {
        boolean vis[] = new boolean[n];
        List<Integer> adj[] = new List[n];
        BitSet prqDp[] = new BitSet[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            prqDp[i] = new BitSet(n);
        }
        for(int[] pre : preq) {
            adj[pre[0]].add(pre[1]);
        }
        
        if(preq.length != 0) {
            for(int i = 0; i < n; i++) {
                if(!vis[i])
                    dfsTopo(i, vis, adj, prqDp);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] qry : queries) {
            res.add(prqDp[qry[1]].get(qry[0]));
        }
        return res;
    }
}