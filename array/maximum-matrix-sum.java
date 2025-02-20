class Solution {
    public long maxMatrixSum(int[][] mat) {
        int  minus = 0;
        for(int i = 0; i < mat.length; i++) {
            int neg = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] < 0) {
                    neg++;
                    mat[i][j] *= -1;
                }
            }
            Arrays.sort(mat[i]);
            neg = neg % 2;
            minus += neg;
        }
        long sum = 0; int min = mat[0][0];
        for(int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
            min = Math.min(min, mat[i][0]);
        }
        sum -= minus % 2 == 1 ? 2 * min : 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}