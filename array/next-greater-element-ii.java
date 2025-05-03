class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int stack[] = new int[nums.length];
        int n = nums.length, top = -1;
        int[] nge = new int[n];
        for(int i = 2 * n-1 ; i >= 0; i--) {
            while(top != -1 && nums[stack[top]] <= nums[i % n])
                top--;
            nge[i % n] = top == -1 ? top : nums[stack[top]];
            stack[++top] = i % n;
        }
        return nge;
    }
}