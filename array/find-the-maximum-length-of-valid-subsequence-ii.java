class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int curr_rem = 0, prv_rem = 0;
        // for(int[] row : dp)
        //     Arrays.fill(row, 1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            curr_rem = nums[i] % k;
            for(int j = 0; j < k; j++) {
                dp[curr_rem][j] = 1 + dp[j][curr_rem];
                ans = Math.max(ans, dp[curr_rem][j]);
            }
        }
        return ans;
    }
}