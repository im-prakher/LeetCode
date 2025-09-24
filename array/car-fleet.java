class Solution {
    public boolean canMeet(int a, int x, int b, int y, int tar) {
        if(x <= y)
            return false;
        while(a <= tar && b <= tar) {
            a += x;
            b += y;
            if(a >= b)
                return true;
        }
        return false;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length, fleet = n, top = -1;
        int[][] det = new int[n][2];
        for(int i = 0; i < n; i++) {
            det[i][0] = position[i];
            det[i][1] = speed[i];
        }
        Arrays.sort(det, (a, b)-> a[0] - b[0]);
        int[][] stack = new int[n][2];
        for(int i = 0; i < n; i++) {
            while(top!= -1 && canMeet(stack[top][0], stack[top][1],
                det[i][0], det[i][1], target)) {
                    top--;
                    fleet--;
            }
            top++;
            stack[top][0] = det[i][0];
            stack[top][1] = det[i][1];
        }
        return fleet;
    }
}