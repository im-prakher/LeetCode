class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDeg = new int[n];
        for(int[] edge : edges) {
            inDeg[edge[1]]++;
        }
        int start = -1, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(inDeg[i] == 0) {
                cnt++;
                start = i;
            }
        }
        if(cnt != 1)
            return -1;
        return start;
    }
}