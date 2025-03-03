class Solution {
    public void dfsTopo(int node, boolean vis[], List<Integer> adj[], List<Integer> topo, Set<Integer> set, Set<Integer> qryDb[]) {
        vis[node] = true;
        set.add(node);
        for(int vtx : adj[node]) {
            qryDb[vtx].addAll(set);
            if(!vis[vtx])
                dfsTopo(vtx, vis, adj, topo, set, qryDb);
        }
        topo.add(node);
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] queries) {
        boolean vis[] = new boolean[n];
        List<Integer> adj[] = new List[n];
        List<Integer> topo = new ArrayList<>();
        Set<Integer> qryDb[] = new HashSet[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            qryDb[i] = new HashSet<>();
        }
        for(int[] pre : preq) {
            adj[pre[0]].add(pre[1]);
        }
        Set<Integer> set = new HashSet<>();
        if(preq.length != 0) {
            for(int i = 0; i < n; i++) {
                if(!vis[i])
                    dfsTopo(i, vis, adj, topo, set, qryDb);
                set.clear();
            }
        }

        List<Boolean> res = new ArrayList<>();
        int k = 0;
        for(int[] qry : queries) {
            if(qryDb[qry[1]].contains(qry[0]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}