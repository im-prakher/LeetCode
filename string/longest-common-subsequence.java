class Solution {
    public int lcs(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + lcs(str1, str2, m - 1, n - 1);
        return Math.max(lcs(str1, str2, m - 1, n), lcs(str1, str2, m, n - 1));
    }

    public int longestCommonSubsequence(String a, String b) {
        //  return lcs(a, b, a.length(), b.length());
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
        return dp[m][n];
    }
}