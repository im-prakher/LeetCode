class Solution {
    class Cell {
        int x, y, steps;
        Cell(int a, int b, int stp) {
            steps = stp;
            x = a; y = b;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] seen = new boolean[n][m];
        Queue<Cell> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    que.offer(new Cell(i, j, 0));
                    ans[i][j] = 0;
                    seen[i][j] = true;
                }
            }
        }
        int[] dir= {-1, 0, 1, 0, -1};
        while(!que.isEmpty()) {
            Cell cell = que.poll();
            int x = cell.x, y = cell.y, stps = cell.steps;
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i], ny = y + dir[i+1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !seen[nx][ny]) {
                    seen[nx][ny] = true;
                    ans[nx][ny] = stps + 1;
                    que.offer(new Cell(nx, ny, ans[nx][ny]));
                }
            }
        }
        return ans;
    }
}