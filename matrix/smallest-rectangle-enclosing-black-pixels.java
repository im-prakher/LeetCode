class Solution {
    public int minArea(char[][] image, int a, int b) {
        if(image.length == 0 || image[0].length == 0) 
            return 0;
        int minh = a, maxh = a, miny = b, maxy = b;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {a, b});
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        image[a][b] = '0';
        while(!que.isEmpty()) {
            int[] loc = que.poll();
            maxh = Math.max(maxh, loc[0]);
            minh = Math.min(minh, loc[0]);
            maxy = Math.max(maxy, loc[1]);
            miny = Math.min(miny, loc[1]);
            for(int i = 0; i < 4; i++) {
                int x = loc[0] + dx[i], y = loc[1] + dy[i];
                if(x >= 0 && x < image.length && y >=0 && y < image[0].length 
                    && image[x][y] == '1') {
                        image[x][y] = '0';
                        que.offer(new int[] {x, y});
                    }
            }
        }
        return (maxh - minh + 1) * (maxy - miny + 1);
    }
}