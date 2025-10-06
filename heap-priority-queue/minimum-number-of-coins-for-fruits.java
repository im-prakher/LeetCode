class Solution {
    int[] dp;
    public int solve(int[] prices, int idx) {
        int n = prices.length;
        if(idx == n)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int coins = prices[idx], minCoin = Integer.MAX_VALUE / 10;
        for(int i = idx+1; i <= Math.min(2 * (idx + 1), n) ; i++) {
            minCoin = Math.min(solve(prices, i), minCoin);
        }
        return dp[idx] = coins + minCoin;
    }
    public int minimumCoins(int[] prices) {
        dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return solve(prices, 0);
    }
}