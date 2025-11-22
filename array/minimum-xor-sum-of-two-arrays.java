class Solution {
    int[] dp;
    public int permute(int[] nums1, int[] nums2, int mask) {
        int n = nums2.length, idx = Integer.bitCount(mask);
        if(idx == n) 
            return 0;
        if(dp[mask] != -1)
            return dp[mask];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if((mask & (1 << i)) == 0) {
                int newMask =  mask | (1 << i);
                int xor = nums1[idx] ^ nums2[i];
                ans = Math.min(ans, xor + permute(nums1, nums2, newMask));
            }
        }
        return dp[mask] = ans;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int mask = 0, n = nums1.length;
        dp = new int[1 << n];
        Arrays.fill(dp, -1);
        return permute(nums1, nums2, mask);
    }
}