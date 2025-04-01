class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n+1];
        long not_pick = 0, pick = 0;
        dp[n-1] = questions[n-1][0];
        for(int i= n-2; i >= 0; i--) {
            pick = questions[i][0];
            int idx = i + questions[i][1] + 1;
            pick += idx < n ? dp[idx] : 0;
            not_pick = dp[i + 1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[0];
    }
}