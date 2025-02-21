class Solution {
    public boolean isCycle(int node, boolean[] vis, List<Integer> adj[]) {
        vis[node] = true;
        for(int vtx : adj[node]) {
            if(!vis[vtx])
                return isCycle(vtx, vis, adj);
            else 
                return true;
        }
        return false;
    }
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        List<Integer> adj[] = new List[n];
        boolean[] vis = new boolean[n];
        int[] par = new int[n];
        Arrays.fill(par, -1);
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            if(left[i]!=-1) {
                adj[i].add(left[i]);
                par[left[i]] = i;
            }
            if(right[i]!=-1) {
                adj[i].add(right[i]);
                par[right[i]] = i;
            }
        }
        int start = -1, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(par[i] == -1) {
                cnt++;
                start = i;
            }
            if(cnt > 1)
                return false;
        }
        for(int i = 0; i < n; i++) {
            if(!vis[i] && isCycle(i, vis, adj)) 
                return false;
        }
        return true;
    }
}