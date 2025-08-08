class Solution {
    public int[][] rangeAddQueries(int n, int[][] qrys) {
        int[][] mat = new int[n][n];
        for(int[] qry : qrys) {
            int r1 = qry[0], r2 = qry[2];
            int c1 = qry[1], c2 = qry[3];
            mat[r1][c1] = 1;
            if(r2 != n-1 && c2 != n-1)
                mat[r2+1][c2+1] = 1;
            if(c2 != n-1)
                mat[r1][c2+1] = -1;
            if(r2 != n-1)
                mat[r2+1][c1] = -1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] += mat[i-1][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        return mat;
    }
}