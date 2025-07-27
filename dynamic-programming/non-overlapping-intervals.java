class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, 
                    (a, b) -> a[1] == b[1] ? a[1] - b[1] : a[0] - b[0]);
        int min = intervals[0][1], cnt = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(min > intervals[i][0]) {
                min = Math.min(min, intervals[i][1]);
                cnt++;
            } else
                min = intervals[i][1];
        }
        return cnt;
    }
}