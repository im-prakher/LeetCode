class Solution {
    public int dfsTime(int[][] moveTime, int i, int j) {
        if(i == 0 && j == 0)
            return 0;
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE/10;
        int minTime = Math.min(dfsTime(moveTime, i-1, j),
                    dfsTime(moveTime, i, j-1));
        return 1 + Math.max(minTime, moveTime[i][j]);
    }

    public int minTimeToReach(int[][] moveTime) {
        int time = 0;
        return dfsTime(moveTime, moveTime.length - 1, moveTime[0].length - 1);
    }
}