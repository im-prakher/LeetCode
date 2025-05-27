class Solution {
    class Cell {
        int x, y;
        Cell(int a, int b) {
            x = a; y = b;
        }
    }
    public void solve(char[][] board) {
        Queue<Cell> que = new LinkedList<>();
        int n = board.length, m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') {
                que.offer(new Cell(i, 0));
                vis[i][0] = true;
            }
            if(board[i][m-1] == 'O') {
                que.offer(new Cell(i, m-1));
                vis[i][m-1] = true;
            }
        }
        for(int j = 1; j < m-1; j++) {
            if(board[0][j] == 'O') {
                que.offer(new Cell(0, j));
                vis[0][j] = true;
            }
            if(board[n-1][j] == 'O') {
                que.offer(new Cell(n-1, j));
                vis[n-1][j] = true;
            }
        }
        int dir[] = {-1, 0, 1, 0, -1};
        while(!que.isEmpty()) {
            Cell cell = que.poll();
            int x = cell.x, y = cell.y;
            board[x][y] = '2';
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i], ny = y + dir[i+1];
                if(valid(nx, ny, n, m) && !vis[nx][ny] && board[nx][ny]=='O') {
                    que.offer(new Cell(nx, ny));
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == 'O' ? 'X' : board[i][j];
                board[i][j] = board[i][j] == '2' ? 'O' : board[i][j];
            }
        }
    }
    boolean valid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}