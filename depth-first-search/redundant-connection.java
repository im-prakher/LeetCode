class Solution {
    int node[];
    void union(int a, int b) {
        node[a] = node[b];
    }
    int find(int a) {
        if(node[a] == a)
            return a;
        return node[a] = find(node[a]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        node = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            node[i] = i;
        }
        int[] ans = new int[2];
        for(int[] edge : edges) {
            int u = find(edge[0]), v = find(edge[1]);
            if(u == v) {
                ans[0] = edge[0];
                ans[1] = edge[1];
                break;
            } else{
                union(u, v);
            }
        }
        return ans;
    }
}