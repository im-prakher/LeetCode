class Solution {
    public long maxMatrixSum(int[][] mat) {
        int sum = 0, minus = 0;
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
        Arrays.sort(mat, (a, b)-> a[0]-b[0]);
        if(minus % 2 == 1) 
            sum -= mat[0][0];
        else 
            sum += mat[0][0];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(i == 0 && j == 0)
                    continue;
                sum += mat[i][j];
            }
        }
        return sum;
    }
}