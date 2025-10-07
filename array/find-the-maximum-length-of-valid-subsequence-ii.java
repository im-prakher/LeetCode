class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[k][k];
        for(int i = 0; i < n; i++) {
            int curr_rem = nums[i] % k;
            for(int prv_rem = 0; prv_rem < k; prv_rem++) {
                dp[curr_rem][prv_rem] = 1 + dp[prv_rem][curr_rem];
                ans = Math.max(ans, dp[curr_rem][prv_rem]);
            }
        }
        return ans;
    }
}