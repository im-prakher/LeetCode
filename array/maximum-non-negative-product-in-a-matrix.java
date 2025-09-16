class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        int[][] neg = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = neg[i][j] = grid[i][j];
                else if(i == 0)
                    dp[i][j] = neg[i][j] = grid[i][j] * dp[i][j-1];
                else if(j == 0)
                    dp[i][j] = neg[i][j] = grid[i][j] * dp[i-1][j];
                else {
                    dp[i][j] = Math.max(
                        grid[i][j] * Math.max(dp[i-1][j], dp[i][j-1]),
                        grid[i][j] * Math.min(neg[i-1][j], neg[i][j-1])
                        );
                    neg[i][j] = Math.min(
                        grid[i][j] * Math.max(dp[i-1][j], dp[i][j-1]),
                        grid[i][j] * Math.min(neg[i-1][j], neg[i][j-1])
                        );
                }
            }
        }
        return dp[n-1][m-1] < 0 ? -1 : dp[n-1][m-1];
    }
}