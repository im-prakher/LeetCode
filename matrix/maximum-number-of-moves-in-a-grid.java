class Solution {

    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        for(int j = m-2; j >= 0; j--) {
            for(int i = 0; i < n; i++) {
                int up = i-1 < 0 ? Integer.MIN_VALUE : grid[i-1][j+1];
                int down = i+1 == n ? Integer.MIN_VALUE : grid[i+1][j+1];
                int cell = grid[i][j];
                if(grid[i][j+1] > cell || up > cell || down > cell)
                    dp[i]++;
                else 
                    dp[i] = 0;
            }
        }
        int ans = 0;
        for(int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}