class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(n == k || k == 1)
            return 0;
        for(int i = 0; i < n-1; i++) {
            weights[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(weights, 0, n-1);
        long ans = 0l;
        for(int i = 0; i < k-1; i++) {
            ans += weights[n-i-2] - weights[i];
        }
        return ans;
    }
}