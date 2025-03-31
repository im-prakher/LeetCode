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
        long max = 0, min = 0;
        for(int i = 0; i < k-1; i++) {
            max += pre[n-i-2];
            min += pre[i];
        }
        return max - min;
    }
}