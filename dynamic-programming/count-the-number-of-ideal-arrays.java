class Solution {
    public int idealArrays(int n, int maxValue) {
        int ans = 0;
        for(int num = 1; num <= maxValue; num++) {
            ans += (maxValue / num - 1) * (n-1) + 1;
        }
        return ans;
    }
}