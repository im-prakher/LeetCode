class Solution {
    int[] par, vtx, edgs;
    void union(int u, int v) {
        par[v] = par[u];
        vtx[u] += vtx[v];
        edgs[u] += edgs[v] + 1;
    }
    int find(int u) {
        if(u == par[u])
            return u;
        return par[u] = find(par[u]);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        par = new int[n];
        vtx = new int[n];
        edgs = new int[n];
        for(int i= 0; i < n; i++) {
            par[i] = i;
            vtx[i] = 1;
        }
        for(int[] edge: edges) {
            int u = find(edge[0]), v = find(edge[1]);
            if(u != v) 
                union(u, v);
            else
                edgs[u]++;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int v = vtx[i];
            if(i == par[i] && edgs[i] == (v * (v-1) / 2)) {                
                cnt++;
            }
        }
        return cnt;
    }
}