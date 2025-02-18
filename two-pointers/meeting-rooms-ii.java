class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length, i = 0;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int[] intv : intervals) {
            start[i] = intv[0];
            end[i++] = intv[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, j = 0;
        for(i = 0; i < n; i++) {
            if(start[i] < end[j]) 
                rooms++;
            else
                j++;
        }
        return rooms;
    }
}