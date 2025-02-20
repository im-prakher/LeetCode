class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b,a));
        for(int i : nums) 
            pq.offer((double)i);
        long sum = 0;
        while(k-- > 0) {
            double val = pq.poll();
            sum += val;
            pq.offer(Math.ceil(val/3));
        }
        return sum;
    }
}