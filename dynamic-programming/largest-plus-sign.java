class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[n][n];
        int cnt = 0;
        for(int[] mine : mines) 
            set.add(mine[0] * n + mine[1]);
        for(int i = 0; i < n; i++) {
            cnt = 0;
            for(int j = n-1; j >= 0; j--) {
                cnt++;
                if(set.contains(i * n + j))
                    cnt = 0;
                dp[i][j] = cnt;
            }
            cnt = 0;
            for(int j = 0; j < n; j++) {
                cnt++;
                if(set.contains(i * n + j))
                    cnt = 0;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }   
        }
        int order = 0;
        for(int j = 0; j < n; j++) {
            cnt = 0;
            for(int i = n-1; i >= 0; i--) {
                cnt++;
                if(set.contains(i*n + j))
                    cnt = 0;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            cnt = 0;
            for(int i = 0; i <= n-1; i++) {
                cnt++;
                if(set.contains(i*n + j))
                    cnt = 0;
                dp[i][j] = Math.min(dp[i][j], cnt);
                order = Math.max(order, dp[i][j]);
            }
        }   
        return order;
    }
}