class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length, MAX = (int)1e9;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int a = j != 0 ? dp[i-1][j-1] : MAX;
                int b = dp[i-1][j];
                int c = j != n-1 ? dp[i-1][j+1] : MAX;
                dp[i][j] = grid[i][j] + Math.min(a, Math.min(b, c));
            }
        }
        int res = MAX;
        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[m-1][i]);
        }
        return res;
    }
}