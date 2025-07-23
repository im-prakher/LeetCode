class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b)-> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int time = events[0][0], attend = 1;
        for(int i = 1; i < events.length; i++) {
            if(time < events[i][1]) {
                attend++;
                time = Math.max(events[i][0], time + 1);
            }
        }
        return attend;
    }
}