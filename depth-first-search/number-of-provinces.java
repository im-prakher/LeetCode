class Solution {
    int par[];
    void union(int x, int y) {
        par[par[x]] = find(par[y]);
    }
    int find(int x) {
        if(x == par[x])
            return x;
        return x = find(par[x]);
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, cnt = n;
        par = new int[n];
        for(int i = 0; i < n; i++) 
            par[i] = i;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                    cnt--;
                }
            }
        }
        return cnt;
    }
}