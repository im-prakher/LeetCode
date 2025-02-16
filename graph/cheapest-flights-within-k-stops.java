class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize distance array, set all distances to MAX_VALUE (infinity)
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Distance to the source is 0
        dist[src] = 0;

        // Run the Bellman-Ford algorithm for at most k+1 iterations
        for (int i = 0; i < k + 1; i++) {
            // Check if there were any updates in this iteration
            // If no updates, we can break early as the algorithm is complete, 
            // suppose for k > num of edges
            if (isBellmanFordCompleted(flights, dist)) {
                break;
            }
        }

        // If the destination still has MAX_VALUE as distance, it is unreachable within k stops
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private boolean isBellmanFordCompleted(int[][] flights, int[] dist) {
        // Clone the current distances to track changes
        int[] prevDist = dist.clone();
        boolean completed = true;

        // Iterate over each flight edge
        for (int[] edge : flights) {
            int u = edge[0];  // source airport
            int v = edge[1];  // destination airport
            int wt = edge[2]; // cost of the flight

            // Check if the current path from u to v is shorter than the previous known path
            if (prevDist[u] != Integer.MAX_VALUE && prevDist[u] + wt < dist[v]) {
                // Update the shortest distance to v
                dist[v] = prevDist[u] + wt;
                completed = false; // Indicate that an update occurred
            }
        }

        // Return true if no updates were made, meaning the algorithm has converged
        return completed;
    }
}