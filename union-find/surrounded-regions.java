class Solution {
    public boolean valid(int x, int y, char[][] board) {
        int n = board.length, m = board[0].length;
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y]=='O';
    }

    public void dfs(char[][] board, int i, int j, boolean vis[][]) {
        vis[i][j] = true;
        board[i][j] = '2';
        int dir[] = {-1, 0, 1, 0, -1};
        for(int k = 0; k < 4; k++) {        
            int nx = i + dir[k], ny = j + dir[k+1];
            if(valid(nx, ny, board) ) {
                dfs(board, nx, ny, vis);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0,vis);
            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1, vis);
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, vis);
            if (board[n - 1][j] == 'O')
                dfs(board, n - 1, j, vis);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == 'O' ? 'X' : board[i][j];
                board[i][j] = board[i][j] == '2' ? 'O' : board[i][j];
            }
        }
    }
}