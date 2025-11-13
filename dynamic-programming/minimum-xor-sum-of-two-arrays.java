class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int permute(int idx, int[] nums1, int[] nums2) {
        int n = nums2.length;
        if(idx == n)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = idx; i < n; i++) {
            swap(nums2, idx, i);
            int xor = nums1[idx] ^ nums2[idx] + permute(idx + 1, nums1, nums2);
            swap(nums2, idx, i);
            ans = Math.min(ans, xor);
        }
        return ans;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        return permute(0, nums1, nums2);
    }
}