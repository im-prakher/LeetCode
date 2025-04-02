class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pre_max[] = new int[n];
        int pre_min[] = new int[n];
        Arrays.fill(pre_min, Integer.MAX_VALUE);
        long ans = 0;
        for(int i = 1; i < n; i++) {
            pre_max[i] = Math.max(nums[i-1], pre_max[i-1]);
            if(i < n-1)
                pre_min[i+1] = Math.min(nums[i], pre_min[i]);
            if(i >= 2)
                ans = (pre_max[i] - pre_min[i]) * nums[i];
        }
        return ans < 0 ? 0 : ans;
    }
    // Do i need to create new operation for this?
    // where to code the publisher for the operation?
    // And how to update the status for optimised price msg? Need to get it from  db or api?
    // How the subsrcibe and price event are related?
}