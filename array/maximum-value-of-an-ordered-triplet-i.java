class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0, diff = 0, ans= 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, diff * nums[i]);
            diff = Math.max(diff, max - nums[i]);
            max = Math.max(nums[i], max);
        }
        return ans < 0 ? 0 : ans;
    }
}