class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int pas = 0;
        int loc[] = new int[1001];
        for(int[] trip : trips) {
            loc[trip[1]] += trip[0];
            loc[trip[2]] -= trip[0];
        }
        for(int i = 0; i < 1001; i++) {
            pas += loc[i];
            if(pas > capacity)
                return false;
        }
        return true;
    }
}