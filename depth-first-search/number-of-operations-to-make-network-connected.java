class Solution {
    int node[];
    void union(int a, int b) {
        node[b] = node[a];
    }

    int find(int a) {
        if(node[a] == a)
            return a;
        return node[a] = find(node[a]);
    }

    public int makeConnected(int n, int[][] conns) {
        node = new int[n];
        for(int i = 0; i < n; i++)
            node[i] = i;
        int extra = 0, comp = n;
        for(int[] con : conns) {
            int u = find(con[0]), v = find(con[1]);
            if(u == v)
                extra++;
            else {
                union(u, v);
                comp--;
            }
        }
        if(comp-1 <= extra)
            return comp-1;
        return -1; 
    }
}