class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int maxTime = events[0][1], attend = 0, i = 0;
        for(int[] event : events) {
            maxTime = Math.max(maxTime, event[1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int time = 1; time <= maxTime; time++) {
            while(i != events.length && events[i][0] <= time) {
                pq.offer(events[i++]);
            }
            if(!pq.isEmpty() && pq.peek()[0] <= time) {
                pq.poll();
                attend++;
            }
        }
        return attend;
    }
}

// [[1,5],[4,4],[2,2],[3,4],[1,1]]
// [[1,5],[1,5],[1,5],[2,3],[2,3]]
// 1 2 3 4 5