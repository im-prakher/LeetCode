class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        int m = meetings.length;
        TreeSet<Integer> set  = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(meetings, (a, b)-> a[0] - b[0]);
        pq.offer(new int[]{meetings[0][1], 0});
        cnt[0] = 1;
        for(int i = 1; i < m; i++)
            set.add(i);
        for(int i = 1; i < m; i++) {
            int[] meet = pq.peek();
            if(meet[0] <= meetings[i][0]) {
                while(!pq.isEmpty() && pq.peek()[0] <= meetings[i][0]) {
                    meet = pq.poll();
                    set.add(meet[1]);
                }
                int room = set.first();
                set.remove(room);
                cnt[room]++;
                pq.offer(new int[]{meetings[i][1], room});
            } else if(pq.size() < n) {
                int room = set.first();
                set.remove(room);
                cnt[room]++;
                pq.offer(new int[]{meetings[i][1], room});
            } else {
                pq.poll();
                cnt[meet[1]]++;
                int intv = meet[0] - meetings[i][0];
                intv = intv > 0 ? intv : 0;
                pq.offer(new int[]{meetings[i][1] + intv, meet[1]});
            }
        }
        int idx = 0, max = cnt[0];
        for(int i = 1; i < n; i++) {
            if(cnt[i] > max) {
                idx  = i;
                max = cnt[i];
            }
        }
        return idx;
    }
}