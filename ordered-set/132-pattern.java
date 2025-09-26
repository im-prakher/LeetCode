class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = -1;
        int[] stack = new int[n];
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int i = n-1; i >= 0; i--) {
            while(top!= - 1 && min[i] >= stack[top]) {
                top--;
            }
            if(top != -1 && stack[top] < nums[i])
                return true;
            if(min[i] < nums[i])
                stack[++top] = nums[i];
        }
        return false;
    }
}