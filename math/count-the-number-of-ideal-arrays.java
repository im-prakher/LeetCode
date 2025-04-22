class Solution {
    int dp[][];
    int func(int n, int maxValue, int prev) {
        if(dp[n][prev] != -1)
            return dp[n][prev];
        if(n ==0)
            return 1;
        int ans = 0;
        for(int i = prev; i <= maxValue; i++) {
            if(i % prev == 0)
                ans += func(n-1, maxValue, i);
        }
        return dp[n][prev] = ans;
    }
    public int idealArrays(int n, int maxValue) {
        int ans = 0;
        dp = new int[n+1][maxValue+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        // for(int num = 1; num <= maxValue; num++) {
        //     int mul = maxValue / num ;
        //     ans += (mul- 1) * (n-1) + 1 ;
        // }
        // return dp[n][maxValue];
        return func(n, maxValue, 1);
    }
}