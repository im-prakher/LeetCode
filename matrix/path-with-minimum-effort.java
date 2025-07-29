class Solution {
    public boolean valid(int x, int y, int n, int m) {
        return x >= 0 &&  x < n && y >= 0 && y < m;
    }
    public int minimumEffortPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] effort = new int[n][m];
        for(int[] row : effort) 
            Arrays.fill(row, (int)1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]-b[2]);
        pq.offer(new int[]{0, 0, 0}); 
        int[] dir = {-1, 0, 1, 0, -1};
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[0], j = node[1], diff = node[2];
            for(int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k+1];
                if(valid(x, y, n, m)) {
                    int curr = Math.max(diff, Math.abs(mat[x][y] - mat[i][j]));
                    if(effort[x][y] > curr) {
                        effort[x][y] = curr;
                        pq.offer(new int[]{x, y, curr});
                    }
                }
            }
        }
        return effort[n-1][m-1];
    }
}