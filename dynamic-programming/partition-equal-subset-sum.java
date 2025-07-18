class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        int target = sum >> 1, n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1])
                    dp[i][j] |= dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][target];
    }
}