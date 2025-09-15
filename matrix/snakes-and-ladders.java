class Solution {
    public int row(int cell, int n) {
        return (cell-1) / n;
    }

    public int col(int cell, int n) {
        int c = (cell-1) % n, r = (cell - 1) / n;
        if(r % 2 == 0)
            return c;
        return n - 1 - c;
    }

    public void reverse(int[][] board, int n) {
        int i = 0, j = n-1;
        while(i < j) {
            int[] tmp = board[i];
            board[i] = board[j];
            board[j] = tmp;
            i++; j--;
        }
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> que = new LinkedList<>();
        int n = board.length;
        boolean [] vis = new boolean[n * n + 1];
        int[] moves = new int[n * n + 1];
        reverse(board, n);
        que.offer(1);
        vis[1] = true;
        while(!que.isEmpty()) {
            int cell = que.poll();
            for(int k = cell+1; k < Math.min(cell + 7, n * n + 1); k++) {
                int i = row(k, n), j = col(k, n);
                int next = (board[i][j] != -1) ? board[i][j] : k;
                if(next == n * n)
                    return moves[cell] + 1;
                if(!vis[next]) {
                    que.offer(next);
                    moves[next] = moves[cell] + 1;
                }
                vis[next] = true;
            }
        }
        return -1;
    }
}