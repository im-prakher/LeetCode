class Solution {
    public long maxMatrixSum(int[][] mat) {
        int  minus = 0, min = mat[0][0];
        long sum = 0;
        for(int i = 0; i < mat.length; i++) {
            int neg = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] < 0) {
                    neg++;
                    mat[i][j] *= -1;
                }
                min = Math.min(min, mat[i][0]);
                sum += mat[i][j];
            }
            neg = neg % 2;
            minus += neg;
        }
        sum -= minus % 2 == 1 ? 2 * min : 0;
        return sum;
    }
}