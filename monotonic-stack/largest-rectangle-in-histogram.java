class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int stack[] = new int[n+1];
        int top = -1, ans = 0;
        for(int i = 0; i <= n; i++) {
            int ele = i == n ? -1 : nums[i];
            while(top!=-1 && nums[stack[top]] >= ele) {
                int val = nums[stack[top--]], j = top == -1 ? -1 : stack[top];
                ans = Math.max(ans, (i-j-1) * val);
            }
            stack[++top] = i;
        }        
        return ans;
    }
}