class Solution {
    int ans;
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void permute(int[] nums1, int[] nums2, String str) {
        int n = nums2.length;
        String[] par = str.split("_");
        int idx = Integer.valueOf(par[0]), sum = Integer.valueOf(par[1]);
        if(idx == n) 
            ans = Math.min(ans, sum);
        for(int i = idx; i < n; i++) {
            swap(nums2, idx, i);
            int xor = nums1[idx] ^ nums2[idx];
            String s = (idx+1) + "_" + (sum + xor);
            permute(nums1, nums2, s);
            swap(nums2, idx, i);
        }
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        ans = Integer.MAX_VALUE;
        permute(nums1, nums2, "0_0");
        return ans;
    }
}