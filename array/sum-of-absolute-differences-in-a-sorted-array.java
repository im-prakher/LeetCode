class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int pre = 0, suf = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            suf += nums[i];
            ans[i] += suf - (n-i) * nums[i];
            int j = n - 1 - i;
            pre += nums[j];
            ans[j] += (j+1) * nums[j] - pre;
        }
        return ans;
    }
}