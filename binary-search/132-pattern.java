class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = -1;
        int[] stack = new int[n];
        for(int i = 0; i < n; i++) {
            while(top!= -1 && stack[top] > nums[i]) {
                if(top > 0)
                    return true;
                top--;
            }
            stack[++top] = nums[i];
        }
        return false;
    }
}