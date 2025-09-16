class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        if(src == des)
            return true;
        List<Integer> adj[] = new List[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);
        vis[src] = true;
        while(!que.isEmpty()) {
            int vtx = que.poll();
            for(int node : adj[vtx]) {
                if(node == des)
                    return true;
                if(!vis[node]) 
                    que.offer(node);
                vis[node] = true;
            }
        }
        return false;
    }
}