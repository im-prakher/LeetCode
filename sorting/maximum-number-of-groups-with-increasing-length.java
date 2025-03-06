class Solution {
    public int maxIncreasingGroups(List<Integer> limits) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b)-> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);
        for(int i = 0; i < limits.size(); i++ ) {
            int[] pair = {limits.get(i), i};
            pq.offer(pair);
        }
        int n = 1;
        List<int[]> tmp = new ArrayList<>();
        while(pq.size() >= n) {
            int dgts = n;
            while(dgts-- > 0) {
                int[] pair = pq.poll();
                if(--pair[0]!=0)
                    tmp.add(pair);
            }
            for(int[] tmpPairs : tmp) 
                pq.offer(tmpPairs);
            tmp = new ArrayList<>();
            n++;
        }
        return n-1;
    }
}