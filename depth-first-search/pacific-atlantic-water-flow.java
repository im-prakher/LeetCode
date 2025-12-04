class Solution {
    boolean isValid(int i, int j, boolean[][] vis) {
        return i >= 0 && j >= 0 && i < vis.length 
                        && j < vis[0].length && !vis[i][j];
    }

    public void bfs(int[][] mat, int a, int b, boolean[][] vis) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {a, b});
        vis[a][b] = true;
        while(!que.isEmpty()) {
            int[] cell = que.poll();
            int i = cell[0], j = cell[1];
            for(int k = 0; k < 4; k++) {
                int ni = i + dr[k], nj = j + dc[k];
                if(isValid(ni, nj, vis) && mat[i][j] <= mat[ni][nj]) {
                    vis[ni][nj] = true;
                    que.offer(new int[] {ni, nj});
                }
            }
        }
        
    }

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] pacVis = new boolean[n][m];
        boolean[][] atlVis = new boolean[n][m];
        for(int j = 0; j < m; j++) {
            if(!pacVis[0][j])
                bfs(mat, 0, j, pacVis);
            if(!atlVis[n-1][j])
                bfs(mat, n-1, j, atlVis);
        }
        for(int i = 0; i < n; i++) {
            if(!pacVis[i][0])
                bfs(mat, i, 0, pacVis);
            if(!atlVis[i][m-1])
                bfs(mat, i, m-1, atlVis);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacVis[i][j] && atlVis[i][j])
                    ans.add(List.of(i, j));
            }
        }
        return ans;
    }
}