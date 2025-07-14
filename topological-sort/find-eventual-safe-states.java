class Solution {
    public boolean isUnsafe(int node, int[] cyc, boolean[] pathVis, int[][] graph) {
        cyc[node] = 1;
        pathVis[node] = true;
        boolean isUnsafe = false;
        for(int vtx: graph[node]) {
            if(cyc[vtx] == 0)
                isUnsafe |= isUnsafe(vtx, cyc, pathVis, graph);
            else if(pathVis[vtx] || cyc[vtx] == 2) {
                cyc[node] = 2;
                return true;
            }
        }
        cyc[node] = isUnsafe ? 2 : 1;
        pathVis[node] = false;
        return isUnsafe;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int cyc[] = new int[n];
        boolean[] pathVis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(cyc[i]==0)
                isUnsafe(i, cyc, pathVis, graph);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(cyc[i] == 1)
                res.add(i);
        }
        return res;
    }
}