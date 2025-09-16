class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n][m];
        int[][] neg = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int val = grid[i][j];
                if(i == 0 && j == 0)
                    dp[i][j] = neg[i][j] = val;
                else if(i == 0)
                    dp[i][j] = neg[i][j] = (val * (dp[i][j-1])) % mod;
                else if(j == 0)
                    dp[i][j] = neg[i][j] = (val * (dp[i-1][j])) % mod;
                else {
                    dp[i][j] = Math.max(
                        val * (Math.max(dp[i-1][j], dp[i][j-1])),
                        val * (Math.min(neg[i-1][j], neg[i][j-1]))
                        ) % mod;
                    neg[i][j] = Math.min(
                        val * (Math.max(dp[i-1][j], dp[i][j-1])),
                        val * (Math.min(neg[i-1][j], neg[i][j-1]))
                        ) % mod;
                }
            }
        }
        return dp[n-1][m-1] < 0 ? -1 : dp[n-1][m-1];
    }
}