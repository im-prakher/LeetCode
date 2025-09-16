class Solution {
    public long moves(int pos, int n, long[][] dp, List<List<Integer>> adj, long mod) {
        if(n == 0)
            return 1;
        if(dp[pos][n] != -1)
            return dp[pos][n];
        long res = 0;
        for(var num : adj.get(pos)) {
            res += moves(num, n-1, dp, adj, mod);
        }
        return dp[pos][n] = res % mod;
    }

    public int knightDialer(int n) {
        List<List<Integer>> adj =  List.of(
            List.of(4, 6),       // 0
            List.of(6, 8),       // 1
            List.of(7, 9),       // 2
            List.of(4, 8),       // 3
            List.of(0, 3, 9),    // 4
            List.of(),           // 5
            List.of(0, 1, 7),    // 6
            List.of(2, 6),       // 7
            List.of(1, 3),       // 8
            List.of(2, 4)        // 9
        );
        long ans = 0, mod = (long)1e9 + 7;
        long[][] dp = new long[10][n+1];
        for(long[] row : dp)
            Arrays.fill(row, -1);
        for(int i = 0; i <= 9; i++) {
            ans += moves(i, n-1, dp, adj, mod) ;
        }
        ans = ans % mod;
        return (int) ans;
    }
}