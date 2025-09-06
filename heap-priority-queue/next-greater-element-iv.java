class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length, k = -1, top = -1, top1 = -1;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        int stack[] = new int[n+1];
        int stack2[] = new int[n+1];
        int tmp[] = new int[n+1];
        for(int i = 0; i < n; i++) {
            while(top1!=-1 && nums[stack2[top1]] < nums[i]) {
                ans[stack2[top1]] = nums[i];
                top1--;
            }
            while(top!=-1 && nums[stack[top]] < nums[i]) {
                tmp[++k] = stack[top--];
            }
            while(k!=-1) {
                stack2[++top1] = tmp[k--];
            }
            stack[++top] = i;
        }
        return ans;
    }
}