class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, ans = (int) 1e9;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < n; i++) 
            que.offer(new int[]{i, 0}); 
        int allMask = (1 << n) - 1, path = 0;
        boolean[][] vis = new boolean[n][allMask+1];
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                int[] next = que.poll();
                int node = next[0], mask = next[1];
                for(int vtx : graph[node]) {
                    int nxtMask = mask | (1 << vtx);
                    if((nxtMask & allMask) == allMask)
                        return path;
                    if(!vis[vtx][nxtMask]) {
                        vis[vtx][nxtMask] = true;
                        que.offer(new int[]{vtx, nxtMask});
                    }
                }
            }
            path++;
        }
        return 0;
    }
}