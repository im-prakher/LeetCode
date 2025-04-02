class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pre_max[] = new int[n];
        int suf_max[] = new int[n];
        long ans = 0;
        for(int i = 1; i < n; i++) {
            pre_max[i] = Math.max(nums[i-1], pre_max[i-1]);
            suf_max[n-i-1] = Math.max(nums[n-i], suf_max[n-i]);
        }
        for(int i= 1; i < n; i++) 
            ans = Math.max(ans, (pre_max[i] - nums[i]) * suf_max[i]);
        return ans < 0 ? 0 : ans;
    }
    // Do i need to create new operation for this?
    // where to code the publisher for the operation?
    // And how to update the status for optimised price msg? Need to get it from  db or api?
    // How the subsrcibe and price event are related?
}