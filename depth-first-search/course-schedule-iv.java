class Solution {
    public void dfsTopo(int node, boolean vis[], List<Integer> adj[], List<Integer> topo) {
        vis[node] = true;
        for(int vtx : adj[node]) {
            if(!vis[vtx])
                dfsTopo(vtx, vis, adj, topo);
        }
        topo.add(node);
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] queries) {
        boolean vis[] = new boolean[n];
        List<Integer> adj[] = new List[n];
        List<Integer> topo = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> qryDb[] = new Set[n];
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            qryDb[i] = new HashSet<>();
        }
        for(int[] pre : preq) {
            adj[pre[0]].add(pre[1]);
        }
        if(preq.length != 0) {
            for(int i = 0; i < n; i++) {
                if(!vis[i])
                    dfsTopo(i, vis, adj, topo);
            }
            for(int i = topo.size()-1; i >= 0; i--) {
                int node = topo.get(i);
                qryDb[node] = new HashSet<>(set);
                set.add(node);
            }
        }
            int k = 0;
            for(int[] qry : queries) {
                if(qryDb[qry[1]].contains(qry[0]))
                    res.add(true);
                else 
                    res.add(false);
                k++;
            }
        return res;
    }
}