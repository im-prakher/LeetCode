class Solution {
    public int countSquares(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];
        int sum = 0;
        for(int i = 0; i < m; i++){
            dp[0][i] = mat[0][i];
            sum += dp[0][i];
        }
        for(int i = 1; i < n; i++) {
            dp[i][0] = mat[i][0];
            sum += dp[i][0];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                int min = Math.min(dp[i-1][j-1], 
                    Math.min(dp[i-1][j], dp[i][j-1]));
                dp[i][j] = mat[i][j] == 1 ? min + 1 : 0;
                sum += dp[i][j];
            }
        }
        return sum;
    }
}