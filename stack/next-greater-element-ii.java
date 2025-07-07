class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int stack[] = new int[nums.length];
        int n = nums.length, top = -1;
        int[] nge = new int[n];
        for(int i = 2*n-1; i >= 0; i--) {
            while(top!=-1 && nums[i % n] > nums[stack[top]]) 
                top--;
            nge[i] = top!= -1 ? nums[stack[top]] : -1;
            stack[++top] = i;
        }
        return nge;
    }
}