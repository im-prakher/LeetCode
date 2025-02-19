class Solution {
    public int maxPotholes(String road, int budget) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int j = 0, holes = 0;
        for(char pot : road.toCharArray()) {
            if(pot == 'x')
               holes++;
            else {
                if(holes!=0)
                    pq.offer(holes);
                holes = 0;
            }
        }
        if(holes!=0)
            pq.offer(holes);
        int cnt = 0;
        while(!pq.isEmpty() && budget > 0) {
            int n = pq.poll();
            cnt += Math.min(n, budget-1);
            budget -= Math.min(n+1, budget);
        }
        return cnt;
    }
}