class Solution {
    int nodes[];
    public int find(int vtx) {
        if(vtx == nodes[vtx])
            return vtx;
        return nodes[vtx] = find(nodes[vtx]);
    }

    public void union(int a, int b) {
        nodes[nodes[a]] = nodes[b];
    }

    public int countComponents(int n, int[][] edges) {
        nodes = new int[n];
        for(int i =0; i < n; i++)
            nodes[i] = i;
        int components = n;
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(find(u) != find(v)) {
                union(u, v);
                components--;
            }
        }
        return components;
    }
}