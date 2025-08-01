class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0, k = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];  
            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                ans++;
            }

        }
        return ans;
    }
}