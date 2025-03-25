class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> horz = new ArrayList<>();
        List<int[]> vert = new ArrayList<>();
        for(int[] rect : rectangles) {
            horz.add(new int[]{rect[1], rect[3]});
            vert.add(new int[]{rect[0], rect[2]});
        }
        horz.sort((a, b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        vert.sort((a, b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int sz = rectangles.length, mrg_h = 0, mrg_v = 0;
        for(int i = 1; i < sz; i++) {
            if(horz.get(i)[0] < horz.get(i-1)[1]) {
                mrg_h++;
                horz.get(i)[1] = Math.max(horz.get(i)[1], horz.get(i-1)[1]);
            }
            if(vert.get(i)[0] < vert.get(i-1)[1]) {
                mrg_v++;
                vert.get(i)[1] = Math.max(vert.get(i)[1], vert.get(i-1)[1]);
            }
        }
        return sz - mrg_h > 2 || sz - mrg_v > 2;
    }
}