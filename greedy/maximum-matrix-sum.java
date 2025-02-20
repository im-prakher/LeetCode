class Solution {
    public long maxMatrixSum(int[][] mat) {
        int neg = 0, min = Integer.MAX_VALUE;
        long sum = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] < 0) {
                    neg++;
                    mat[i][j] *= -1;
                }
                min = Math.min(min, mat[i][j]);
                sum += mat[i][j];
            }
        }
        sum -= neg % 2 == 1 ? 2 * min : 0;
        return sum;
    }
}