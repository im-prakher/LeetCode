class Solution {
    public boolean valid(int x, int y, int[][] board) {
        int n = board.length, m = board[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public void dfs(int[][] board, int i, int j) {
        if(board[i][j] == 1) {
            board[i][j] = 2;
            int dir[] = {-1, 0, 1, 0, -1};
            for(int k = 0; k < 4; k++) {        
                int nx = i + dir[k], ny = j + dir[k+1];
                if(valid(nx, ny, board)) {
                    dfs(board, nx, ny);
                }
            }
        }
    }

    public int numEnclaves(int[][] board) {
          int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 1) 
                dfs(board, i, 0);
            if (board[i][m - 1] == 1) 
                dfs(board, i, m - 1);
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 1)
                dfs(board, 0, j);
            if (board[n - 1][j] == 1)
                dfs(board, n - 1, j);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += board[i][j] == 1 ? 1 : 0;
            }
        }
        return cnt;
    }
}