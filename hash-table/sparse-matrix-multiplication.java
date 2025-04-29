class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        boolean zeroRow[] = new boolean[mat1.length];
        boolean zeroCol[] = new boolean[mat2[0].length];
        for(int i = 0; i < mat1.length; i++ ) {
            boolean flag = true;
            for(int k = 0; k < mat2.length; k++) {
                if(mat1[i][k] != 0) {
                    flag = false;
                    break;
                }
            }
            zeroRow[i] = flag;
        }
        for(int j = 0; j < mat2[0].length; j++ ) {
             boolean flag = true;
            for(int k = 0; k < mat2.length; k++) {
                if(mat2[k][j] != 0) {
                    flag = false;
                    break;
                }
            }
            zeroCol[j] = flag;
        }
        int mat3[][] = new int[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat2[0].length; j++) {
                if(zeroRow[i] || zeroCol[j]) {
                    mat3[i][j] = 0;
                    continue;
                }
                for(int k = 0; k < mat2.length; k++) {
                    mat3[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return mat3;
    }
}