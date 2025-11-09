class Solution {
    public int minPath(int i, int n, int[][] graph) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        que.offer(new int[]{i, 0, 0});
        int all = (1 << n) - 1;
        while(!que.isEmpty()) {
            int[] next = que.poll();
            int node = next[0], len = next[1], mask = next[2];
            mask |= (1 << node);
            if((mask & all) == all)
                return len;
            for(int vtx : graph[node]) {
                que.offer(new int[]{vtx, len + 1, mask});
            }
        }
        return -1;
    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, ans = (int) 1e9;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, minPath(i, n, graph));
        }
        return ans;
    }
}