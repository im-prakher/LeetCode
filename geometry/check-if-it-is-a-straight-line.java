class Solution {
    public int abs(int n) {
        return Math.abs(n);
    }
    public boolean checkStraightLine(int[][] cord) {
        int n = cord.length;
        Arrays.sort(cord, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i  = 1; i < n-1; i++) {
            if(abs(cord[i][0] - cord[i-1][0]) != abs(cord[i+1][0] - cord[i][0])
                || abs(cord[i][1] - cord[i-1][1]) 
                    != abs(cord[i+1][1] - cord[i][1]))
                return false;
        }
        return true;
    }
}