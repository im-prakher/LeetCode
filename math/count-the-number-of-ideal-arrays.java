class Solution {
    long dp[][];
    int MOD = 1000_000_007;
    long func(int n, int maxValue, int prev) {
        if(n ==0)
            return 1;
        if(dp[n][prev] != -1)
            return dp[n][prev];
        long ans = 0;
        for(int i = prev; i <= maxValue; i++) {
            if(i % prev == 0)
                ans += func(n-1, maxValue, i);
        }
        return dp[n][prev] = ans % MOD;
    }
    public int idealArrays(int n, int maxValue) {
        dp = new long[n+1][maxValue+1];
        for(long[] row : dp)
            Arrays.fill(row, -1);
        return (int)func(n, maxValue, 1);
    }
}