class Solution {
    public int row(int cell, int n) {
        // if((cell / n) % 2 == 0)
            return (cell-1) / n;
    }

    public int col(int cell, int n) {
        int c = (cell-1) % n;
        if(((cell - 1) / n) % 2 == 0)
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
        // do bfs for next 6 cells
        //if any cell has snake/ladder push that in queue
        //if unable to reach last cell & queue becomes empty return -1
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {1, 0});
        Set<Integer> vis = new HashSet<>();
        int n = board.length;
        reverse(board, n);
        vis.add(1);
        int ans = Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            int[] cell = que.poll();
            if(cell[0] == n*n)
                ans = Math.min(ans, cell[1]);
            for(int k = cell[0]+1; k < Math.min(cell[0] + 7, n * n + 1); k++) {
                int i = row(k, n), j = col(k, n);
                if(board[i][j] != -1) {
                    if(!vis.contains(board[i][j])) 
                        que.offer(new int[] {board[i][j], cell[1]+1});
                    vis.add(board[i][j]);
                } else if(!vis.contains(k)) {
                    que.offer(new int[] {k, cell[1]+1});
                }
                vis.add(k);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}