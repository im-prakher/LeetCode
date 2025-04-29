class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int zeroRow[] = new int[mat1.length];
        int zeroCol[] = new int[mat2[0].length];
        for(int i = 0; i < mat1.length; i++ ) {
            zeroRow[i] = Arrays.stream(mat1[i]).sum();            
        }
        for(int j = 0; j < mat2[0].length; j++ ) {
            for(int k = 0; k < mat2.length; k++)
                zeroCol[j] += mat2[k][j];
        }
        int mat3[][] = new int[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat2[0].length; j++) {
                if(zeroRow[i] == 0 || zeroCol[j] == 0) {
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