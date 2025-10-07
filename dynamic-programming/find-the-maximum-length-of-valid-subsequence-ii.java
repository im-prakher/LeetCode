class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int curr_rem = nums[i] % k;
            for(int j = 0; j < k; j++) {
                dp[curr_rem][j] = 1 + dp[j][curr_rem];
                ans = Math.max(ans, dp[curr_rem][j]);
            }
        }
        return ans;
    }
}