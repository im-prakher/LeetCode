class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        long not_pick = 0, pick = 0;
        for(int i= n-1; i >= 0; i--) {
            pick = questions[i][0];
            if(i + questions[i][1] + 1 < n)
                pick += dp[i + questions[i][1] + 1];
            not_pick = i < n-1 ? dp[i + 1] : 0;
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[0];
    }
}