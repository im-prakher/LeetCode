class Solution {
    public long maximumTripletValue(int[] nums) {
        long min = nums[1], max = Math.max(nums[0], nums[1]), diff = Math.max(0, max - min), ans= 0;
        int n = nums.length;
        for(int i = 2; i < n; i++) {
            ans = Math.max(ans, diff * nums[i]);
            diff = Math.max(diff, max - min);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i-1], max);
        }
        return ans < 0 ? 0 : ans;
    }
}