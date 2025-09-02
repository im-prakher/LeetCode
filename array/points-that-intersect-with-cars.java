class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int line[] = new int[102];
        for(var pts : nums) {
            line[pts.get(0)] += 1;
            line[pts.get(1) + 1] -= 1;
        }
        int ans = 0, sum = 0;
        for(int ind : line) {
            sum += ind;
            if(sum != 0)
                ans++;
        }
        return ans;
    }
}