class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = dist[0] = 0;
        for(int i = 1; i < n; i++) {
            for(int[] time : times) {
                if(dist[time[0]] != Integer.MAX_VALUE 
                    && dist[time[0]] + time[2] < dist[time[1]]) {
                        dist[time[1]] = dist[time[0]] + time[2];
                }
            }
        }

        int ans = 0;
        for(int dis : dist) {
            ans = Math.max(dis, ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}