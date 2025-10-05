class Solution {

    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int j = m-2; j >= 0; j--) {
            for(int i = 0; i < n; i++) {
                int up = i-1 < 0 ? Integer.MIN_VALUE : grid[i-1][j+1];
                int down = i+1 == n ? Integer.MIN_VALUE : grid[i+1][j+1];
                int cell = grid[i][j];
                if(grid[i][j+1] > cell)
                    next[i] = prev[i] + 1;
                else if(up > cell)
                    next[i] = prev[i-1] + 1;
                else if(down > cell)
                    next[i] = prev[i+1] + 1;
                else 
                    next[i] = 0;
            }
            int[] tmp = prev;
            prev = next;
            next = tmp;
        }
        int ans = 0;
        for(int i : prev) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}