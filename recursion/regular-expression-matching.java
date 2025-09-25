class Solution {
    public boolean isMatch(String str, String pat) {
        int m = str.length(), n = pat.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1; j<=n; j++){
            if(pat.charAt(j-1) == '*')
                dp[0][j]  = true;
            else 
                break;
        }
        for(int i = 1; i <=m; i++) {
            for(int j = 1; j <=n; j++) {
                char ch = str.charAt(i-1), p = pat.charAt(j-1);
                if(p == '.' || ch == p)
                    dp[i][j] =  dp[i-1][j-1];
                else if(p == '*')
                    dp[i][j] =  dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}