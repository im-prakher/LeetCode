class Solution {
    int[] out;
    int dfs(int node, HashMap<Integer, Integer> adj[], boolean[] vis) {
        vis[node] = true;
        int cnt = 0;
        for(var vtx : adj[node].entrySet()) {
            int key = vtx.getKey(), val = vtx.getValue();
            if(vis[key]) {
                cnt += Math.min(val, out[key]);
            } else {
                cnt += dfs(key, adj, vis);
            }
        }
        out[node] -= cnt;
        return cnt;
    }
    public int maximumRequests(int n, int[][] requests) {
        out = new int[n];
        HashMap<Integer, Integer> adj[] = new HashMap[n];
        for(int i = 0; i < n; i++)
            adj[i] = new HashMap<>();
        for(int[] req : requests) {
            out[req[0]]++;
            adj[req[0]].put(req[1], adj[req[0]].getOrDefault(req[1], 0) + 1);
        }
        boolean[] vis = new boolean[n];
        int[] inp = out.clone();
        for(int i = 0; i < n; i++) {
            if(!vis[i] && out[i] > 0) {
                dfs(i, adj, vis);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += inp[i] - out[i];
        }
        return ans;
    }
}