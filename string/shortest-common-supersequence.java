class Solution {
      public int[][] lcsMat(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = lcsMat(str1, str2);
        int i = dp.length-1, j = dp[0].length-1;
        StringBuilder res = new StringBuilder();
        while(i > 0 || j > 0) {
            if(i > 0 && dp[i][j] == dp[i-1][j]) {
                res.append(str1.charAt(--i));
            } else if (j > 0 && dp[i][j] == dp[i][j-1]) {
                res.append(str2.charAt(--j));
            } else {
                res.append(str1.charAt(--i));
                --j;
            }
        }
        return res.toString();
    }
}