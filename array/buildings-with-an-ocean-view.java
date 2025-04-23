class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length, max = -1;
        List<Integer> list = new ArrayList<>();
        for(int i = n-1; i >= 0; i--) {
            if(heights[i] > max) {
                list.add(i);
                max = Math.max(max, heights[i]);
            }
        }
        int[] ans = new int[list.size()];
        int k = list.size()-1;
        for(int idx : list) {
            ans[k--] = idx;
        }
        return ans;
    }
}