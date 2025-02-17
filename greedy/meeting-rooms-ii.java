class Solution {
    public int minMeetingRooms(int[][] intv) {
        Arrays.sort(intv, (a, b) -> (a[1] == b[1]) ? a[0]-b[0] : a[1]-b[1]);
        int cnt = 1, finish = intv[0][1];
        for(int i = 1; i < intv.length; i++) {
            if(finish > intv[i][0]) {
                finish = Math.min(finish, intv[i][1]);
                cnt++;
            } else {
                finish = intv[i][1];
            }
        }
        return cnt;
    }
}