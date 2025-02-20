class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        for(int i : nums) 
            pq.offer(i);
        long sum = 0;
        while(k-- > 0) {
            int val = pq.poll();
            sum += val;
            pq.offer((int)Math.ceil(val/3.0));
        }
        return sum;
    }
}