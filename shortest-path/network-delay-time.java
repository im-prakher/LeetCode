class Solution {
    public record Node(int val, int wt) {}
    //Dijkstra's Algorithm
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        List<Node> adj[] = new List[n+1];
        for(int i = 0; i < n+1; i++)
            adj[i] = new ArrayList<>();
        for(int time[] : times) {
            adj[time[0]].add(new Node(time[1], time[2]));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = dist[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        pq.offer(new Node(k, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for(Node vtx : adj[node.val]) {
                if(dist[node.val]!= Integer.MAX_VALUE 
                        && dist[node.val] + vtx.wt < dist[vtx.val]) {
                    dist[vtx.val] = dist[node.val] + vtx.wt;
                    pq.offer(vtx);
                }
            }
        }
        int ans = 0;
        for(int dis : dist) {
            ans = Math.max(ans, dis);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}