class Solution {
    long dp[];
    public long solve(int[][] ques, int idx) {
        if(idx >= ques.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        long pick = ques[idx][0] + solve(ques, idx + ques[idx][1] + 1);
        long not_pick = solve(ques, idx + 1);
        return dp[idx] = Math.max(pick, not_pick);
    }

    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        int n = questions.length;
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