class Solution {
    boolean isValid(int i, int j, boolean[][] vis) {
        return i >= 0 && j >= 0 && i < vis.length 
                        && j < vis[0].length && !vis[i][j];
    }

    public void dfs(int[][] mat, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++) {
            int ni = i + dr[k], nj = j + dc[k];
            if(isValid(ni, nj, vis) && mat[i][j] <= mat[ni][nj]) {
                dfs(mat, ni, nj, vis);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] pacVis = new boolean[n][m];
        boolean[][] atlVis = new boolean[n][m];
        for(int j = 0; j < m; j++) {
            if(!pacVis[0][j])
                dfs(mat, 0, j, pacVis);
            if(!atlVis[n-1][j])
                dfs(mat, n-1, j, atlVis);
        }
        for(int i = 0; i < n; i++) {
            if(!pacVis[i][0])
                dfs(mat, i, 0, pacVis);
            if(!atlVis[i][m-1])
                dfs(mat, i, m-1, atlVis);
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