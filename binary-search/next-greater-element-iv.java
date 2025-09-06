class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length, k = 0, top = -1;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        int stack[] = new int[100_002];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b)-> nums[a]- nums[b]);
        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty()) {
                if(nums[pq.peek()] > nums[i]) 
                    break;
                ans[pq.poll()] = nums[i];
            }
            while(top!=-1 && nums[stack[top]] < nums[i]) {
                pq.offer(stack[top]);
                top--;
            }
            stack[++top] = i;
        }
        return ans;
    }
}