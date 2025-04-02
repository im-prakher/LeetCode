class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long pre_max[] = new long[n];
        long suf_max[] = new long[n];
        long ans = 0;
        for(int i = 1; i < n-1; i++) {
            pre_max[i] = Math.max(nums[i-1], pre_max[i-1]);
            suf_max[n-i-1] = Math.max(nums[n-i], suf_max[n-i]);
        }
        for(int i= 1; i < n-1; i++) 
            ans = Math.max(ans, (pre_max[i] - nums[i]) * suf_max[i]);
        return ans < 0 ? 0 : ans;
    }
}