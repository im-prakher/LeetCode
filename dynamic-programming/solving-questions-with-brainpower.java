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
        dp = new long[questions.length+2];
        Arrays.fill(dp, -1);
        return solve(questions, 0);
    }
}