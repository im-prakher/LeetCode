class Solution {
    public long maximumTotalDamage(int[] power) {
        int max = 0;
        for(int i : power) {
            max = Math.max(max, i);
        }
        long dp[] = new long[max+1];
        for(int i : power) {
            dp[i] += i;
        }
        if(max >= 2)
            dp[2] = Math.max(dp[2], dp[1]);
        for(int i = 3; i <= max; i++) {
            dp[i] = Math.max(dp[i-2], Math.max(dp[i-1], dp[i-3] + dp[i]));
        }
        return dp[max];
    }
}