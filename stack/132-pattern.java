class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = -1;
        int[] stack = new int[n];
        for(int i = 0; i < n; i++) {
            while(top!= -1 && nums[stack[top]] > nums[i]) {
                if(top > 0 && stack[top-1] < nums[i])
                    return true;
                top--;
            }
            stack[++top] = i;
        }
        return false;
    }
}