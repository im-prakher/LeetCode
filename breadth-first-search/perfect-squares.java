class Solution {
    int[] dp;
    int func(int n) {
        if(dp[n] != -1)
            return dp[n];
        int min = (int) 1e4;
        for(int i = 1; i * i <= n; i++) {
            int sqr = i * i;
            if(n % sqr == 0) {
                min = Math.min(min, n / sqr);
            } else {
                min = Math.min(min, n / sqr + func(n % sqr));
            }
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j = 1; j <= n; j++) {
            for(int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}