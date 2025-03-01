class Solution {
    public int maximalSquare(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dp[][] = new int[n][m];
        int maxLen = 0;
        for(int i = 0; i < m; i++) {
            dp[0][i] = mat[0][i] - '0';
            maxLen = Math.max(maxLen, dp[0][i]);
        }
        for(int j = 0; j < n; j++) {
            dp[j][0] = mat[j][0] - '0';
            maxLen = Math.max(maxLen, dp[j][0]);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(mat[i][j] == '1')
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