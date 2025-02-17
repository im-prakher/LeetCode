class Solution {
    public int minMeetingRooms(int[][] intv) {
        Arrays.sort(intv, (a, b) -> (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 1, finish; 
        pq.offer(intv[0][1]);
        for(int i = 1; i < intv.length; i++) {
            finish = pq.peek();
            if(finish > intv[i][0]) {
                cnt++;
            } else {
                pq.poll();
            }
            pq.offer(intv[i][1]);
        }
        return cnt;
    }
}