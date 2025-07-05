class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length, ans = nums[0];
        for(int i = 0; i < n; i++) 
            pq.offer(nums[i]);
        for(int i = 0; i < n - k +1; i++)
            ans = pq.remove();
        return ans;
    }
}