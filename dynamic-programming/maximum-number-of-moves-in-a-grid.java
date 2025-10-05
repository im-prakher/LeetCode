class Solution {
int m, n;
    int[][] dp;
    int[][] grid;
    int[] dy = {-1, 0, 1}; 
    int answer = 0;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n]; 

        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, dfs(i, 0)); 
        }

        return answer;
    }

    private int dfs(int y, int x) {
        if(dp[y][x] != 0) return dp[y][x];

        int maxStep = 0;
        for(int dir = 0; dir < 3; dir++) {
            int ny = y + dy[dir];
            int nx = x + 1;
            if(ny >= 0 && ny < m && nx < n && grid[ny][nx] > grid[y][x]) {
                maxStep = Math.max(maxStep, 1 + dfs(ny, nx));
            }
        }

        dp[y][x] = maxStep;
        return maxStep;
    }
}