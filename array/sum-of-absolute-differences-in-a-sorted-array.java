class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            sum += nums[i];
            ans[i] = sum - (n-i) * nums[i];
        }
        sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            ans[i] += (i+1) * nums[i] - sum;
        }
        return ans;
    }
}