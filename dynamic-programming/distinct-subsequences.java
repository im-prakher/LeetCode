class Solution {
    // int dp[][];
    // public int solve(char[] s, char[] t, int n, int m) {
    //     if(m == 0)
    //         return 1;
    //     if(n == 0 || n < m)
    //         return 0;
    //     if(dp[n][m]!= -1)
    //         return dp[n][m];
    //     int no_pick = solve(s, t, n-1, m), pick = 0;
    //     if(s[n-1] == t[m-1])
    //         pick = solve(s, t, n-1, m-1);
    //     return dp[n][m] = pick + no_pick;
    // }

   public int distinct(String a, String b) {
        //  return lcs(a, b, a.length(), b.length());
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if(a.charAt(i-1) == b.charAt(j-1)) 
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public int numDistinct(String s, String t) {
        return distinct(t, s);
    }
}