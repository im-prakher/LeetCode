class Solution {
    public int maximalSquare(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dp[][] = new int[n][m];
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int digit = mat[i][j] == '1' ? 1 : 0;
                if(i == 0 || j == 0)
                    dp[i][j] = digit;
                else if(digit == 1)                 
                    dp[i][j] = Math.min(dp[i-1][j-1], 
                                Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                else
                    dp[i][j] = 0;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}