class Solution {
    public int abs(int n) {
        return Math.abs(n);
    }
    public boolean checkStraightLine(int[][] cord) {
        int n = cord.length;
        for(int i  = 1; i < n-1; i++) {
            if(abs(cord[i][0] - cord[i-1][0]) != abs(cord[i+1][0] - cord[i][0])
                || abs(cord[i][1] - cord[i-1][1]) 
                    != abs(cord[i+1][1] - cord[i][1]))
                return false;
        }
        return true;
    }
}