class Solution {
    public int countSquares(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = mat[i][j];
                else if(mat[i][j] == 1)                 
                    dp[i][j] = Math.min(dp[i-1][j-1], 
                                Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                else
                    dp[i][j] = 0;
                sum += dp[i][j];
            }
        }
        return sum;
    }
}