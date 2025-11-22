class Solution {
    Map<Integer, Integer> dp;
    
    int setBit(int mask, int i) {
        return mask | (1 << i);
    }

    public int permute(int[] nums1, int[] nums2, int mask) {
        int n = nums2.length, idx = Integer.bitCount(mask);
        if(idx == n) 
            return 0;
        if(dp.containsKey(mask))
            return dp.get(mask);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int newMask = setBit(mask, i);
            if(newMask != mask) {
                int xor = nums1[idx] ^ nums2[i];
                ans = Math.min(ans, xor + permute(nums1, nums2, newMask));
            }
        }
        dp.put(mask, ans);
        return ans;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        dp = new HashMap<>();
        int mask = 0, n = nums1.length;
        return permute(nums1, nums2, mask);
    }
}