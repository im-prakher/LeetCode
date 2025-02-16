class Solution {
    int nodes[];
    int findRoot(int root) {
        if(nodes[root] == root)
            return root;
        return nodes[root] = findRoot(nodes[root]);
    }
    void union(int u, int v){
        nodes[nodes[v]] = nodes[nodes[u]];
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, m = isConnected[0].length;
        int ans = n;        
        nodes = new int[n];
        for(int i = 0; i < n; i++) 
            nodes[i] = i;
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isConnected[i][j] == 1 && findRoot(i) != findRoot(j)) {
                    union(i, j);
                    ans--;
                }
            }
        }
        return ans;
    }
}