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
                if(par[left[i]] != -1)
                    return false;
                par[left[i]] = i;
            }
            if(right[i]!=-1) {
                adj[i].add(right[i]);
                if(par[right[i]] != -1)
                    return false;
                par[right[i]] = i;
            }
        }
        int start = -1, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(par[i] == -1) {
                cnt++;
                start = i;
            }
        }
        if(cnt > 1 || start == -1)
            return false;

        if(isCycle(start, vis, adj)) 
                return false;
        return true;
    }
}