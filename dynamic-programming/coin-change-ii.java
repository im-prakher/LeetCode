class Solution {
    public int change(int amount, int[] nums) {
        int n = nums.length, MAX = (int) 1e9;
        int dp[][] = new int[n+1][amount+1];
        Arrays.fill(dp[0], 0);
        for(int i= 0; i <= n; i++)
            dp[i][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i-1][j];
                if(j >= nums[i-1])
                    dp[i][j] += dp[i][j-nums[i-1]];
            }
        }
        return dp[n][amount];
    }
}