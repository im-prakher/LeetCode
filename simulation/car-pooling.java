class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int pas = 0;
        for(int i = 0; i <= 1000; i++) {
            pas = 0;
            for(int[] trip : trips) {
                if(i < trip[1] || i > trip[2])
                    continue;
                pas += trip[0];
            }
            if(pas > capacity)
                return false;
        }
        return true;
    }
}