class Solution {
    int dp[][];
    public int solve(int i, int j, int[] bal) {
        if(i >= j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        for(int k = i; k < j; k++) {
            int res = solve(i, k, bal) + solve(k + 1, j, bal) 
                        + bal[i-1] * bal[k] * bal[j];
            ans = Math.max(ans, res);
        }
        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length, b = n+2;
        int bal[] = new int[n+2];
        bal[0] = bal[n+1] = 1;
        for(int i = 1; i <= n; i++)
            bal[i] = nums[i-1];
        dp = new int[b][b];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return solve(1, bal.length-1, bal);
        // for(int i = n; i > 0; i-- ){
        //     for(int j = i; j <= n; j++){
        //         int maxCoins = 0, coins = 0;
        //         for(int k = i; k <= j; k++) {
        //             coins = dp[i][k-1] + dp[k+1][j] + bal[i-1] * bal[k] * bal[j+1];
        //             maxCoins = Math.max(coins, maxCoins);
        //         }
        //         dp[i][j] = maxCoins;
        //     }
        // }
        // return dp[1][n];
        for(int i = b-1; i >= 1; i--) {
            for(int j = i+1; j < b; j++) {
                int res = 0;
                for(int k = i; k < j; k++) {
                    res = dp[i][k] + dp[k+1][j] + bal[i-1] * bal[k] * bal[j];
                    dp[i][j] = Math.max(dp[i][j], res);
                }
            }
        }
        return dp[1][b-1];
    }
}