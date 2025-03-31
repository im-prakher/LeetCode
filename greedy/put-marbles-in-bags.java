class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(n == k || k == 1)
            return 0;
        long pre[] = new long[n-1];
        for(int i = 0; i < n-1; i++) {
            pre[i] = (long)(weights[i] + weights[i+1]);
        }
        Arrays.sort(pre);
        long ans = 0l;
        for(int i = 0; i < k-1; i++) {
            ans += pre[n-i-2] - pre[i];
        }
        return ans;
    }
}